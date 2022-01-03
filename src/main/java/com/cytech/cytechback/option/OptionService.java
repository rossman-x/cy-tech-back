package com.cytech.cytechback.option;


import com.cytech.cytechback.criteria.Criteria;
import com.cytech.cytechback.orientation.Orientation;
import com.cytech.cytechback.orientation.OrientationRepository;
import com.cytech.cytechback.user.User;
import com.cytech.cytechback.user.UserDTO;
import com.cytech.cytechback.wish.Wish;
import com.cytech.cytechback.wish.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OptionService implements IOptionService {

    public static final int LIMIT_PER_OPTION = 2;

    @Autowired
    private OptionAssembler optionAssembler;

    @Autowired
    private WishRepository wishRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private OrientationRepository orientationRepository;

    @Override
    public List<OptionDTO> getOptionsBySpecialityId(Long specialityId) {
        Set<Option> options = optionRepository.selectAllBySpecialityId(specialityId);
        options.forEach(option -> option.setSpecialitySet(null));
        List<OptionDTO> optionsAsList = options.stream().map(optionAssembler::toDto).collect(Collectors.toList());
        return optionsAsList;
    }

    @Override
    public List<Long> setOrientationForOption(Long optionId) {
        Option option = this.optionRepository.getById(optionId);
        Set<Criteria> criteriaSet = option.getCriterias();
        Set<Wish> usersWishes = option.getWishes();

        Map<Long, Integer> rankingIds = new HashMap<>();

        int LEFT_PER_WISH_RANK = LIMIT_PER_OPTION;

        RankFor:
        for (int wishRank = 1; wishRank <= 4; wishRank++) {
            if (LEFT_PER_WISH_RANK <= 0)
                break RankFor;

            List<User> localUsers = new ArrayList<>();
            WishFor:
            for (Wish wish : usersWishes) {
                if (wish.getRank() != wishRank)
                    continue WishFor;
                User userOfWish = wish.getUserOfWish();
                localUsers.add(userOfWish);
            }
            //All user are added for rank wishRank
            CriteriaFor:
            for (Criteria criteria : criteriaSet) {
                List<User> sortedUsersByCriteria = sortUsersByCriteria(localUsers, criteria.getContent());
                CriteriaRankFor:
                for (int criteriaRank = 0; criteriaRank < sortedUsersByCriteria.size(); criteriaRank++) {
                    User u = sortedUsersByCriteria.get(criteriaRank);
                    Long uId = u.getId();
                    int numberOfPoints = (5 - wishRank) * (sortedUsersByCriteria.size() - criteriaRank);
                    if (rankingIds.containsKey(uId))
                        numberOfPoints = rankingIds.get(uId) + numberOfPoints;
                    rankingIds.put(uId, numberOfPoints);
                }
            }
            LEFT_PER_WISH_RANK -= localUsers.size();
        }

        List<Long> rankedUsers = rankingIds.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .map(Map.Entry::getKey).collect(Collectors.toList());

        if (rankedUsers.size() > LIMIT_PER_OPTION)
            rankedUsers = rankedUsers.subList(0, LIMIT_PER_OPTION);

        for (int i = 0; i < rankedUsers.size(); i++) {
            Long userId = rankedUsers.get(i);
            Orientation orientation = new Orientation();
            orientation.setOption(option);
            User user = new User();
            user.setId(userId);
            orientation.setUserOption(user);
            orientation.setRemarque("Rang " + i);
            this.wishRepository.deleteAllByUserId(userId);
            this.orientationRepository.save(orientation);
        }


        return rankedUsers;
    }

    @Override
    public OptionDTO getOption(Long optionId) {
        Option o = this.optionRepository.findById(optionId).get();
        return this.optionAssembler.toDto(o);
    }

    @Override
    public List<OptionDTO> getOptions() {
        List<Option> options = this.optionRepository.findAll();
        return this.optionAssembler.toDtoList(options);
    }

    public List<User> sortUsersByCriteria(List<User> users, String criteria) {
        if (criteria.equals("NB_ABSENCE"))
            return sortUsersByNbAbsence(users);
        if (criteria.equals("MOYENNE"))
            return sortUserByAverage(users, -1);

        if (criteria.contains("MOYENNE_")) {
            int subjectId = Integer.valueOf(criteria.replace("MOYENNE_", ""));
            return sortUserByAverage(users, subjectId);
        }

        return Collections.emptyList();
    }

    class ComparatorAverage implements Comparator<User> {

        private int subjectId;

        public ComparatorAverage(int subjectId) {
            this.subjectId = subjectId;
        }

        @Override
        public int compare(User o1, User o2) {
            double u1Avg = o1.getAverage(subjectId);
            double u2Avg = o2.getAverage(subjectId);
            return Double.compare(u2Avg, u1Avg);
        }
    }

    public List<User> sortUserByAverage(List<User> users, int subjectId) {
        ComparatorAverage comparatorAverage = new ComparatorAverage(subjectId);
        users = users.stream().sorted(comparatorAverage).collect(Collectors.toList());
        return users;
    }

    public List<User> sortUsersByNbAbsence(List<User> users) {
        return users.stream().sorted().collect(Collectors.toList());
    }
}
