package config.user.domain;

import java.util.ArrayList;
import java.util.List;

public class CUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public CUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(int value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(int value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(int value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(int value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(int value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(int value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(int value1, int value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(int value1, int value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andExpIsNull() {
            addCriterion("`exp` is null");
            return (Criteria) this;
        }

        public Criteria andExpIsNotNull() {
            addCriterion("`exp` is not null");
            return (Criteria) this;
        }

        public Criteria andExpEqualTo(int value) {
            addCriterion("`exp` =", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpNotEqualTo(int value) {
            addCriterion("`exp` <>", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpGreaterThan(int value) {
            addCriterion("`exp` >", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpGreaterThanOrEqualTo(int value) {
            addCriterion("`exp` >=", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpLessThan(int value) {
            addCriterion("`exp` <", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpLessThanOrEqualTo(int value) {
            addCriterion("`exp` <=", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpIn(List<Integer> values) {
            addCriterion("`exp` in", values, "exp");
            return (Criteria) this;
        }

        public Criteria andExpNotIn(List<Integer> values) {
            addCriterion("`exp` not in", values, "exp");
            return (Criteria) this;
        }

        public Criteria andExpBetween(int value1, int value2) {
            addCriterion("`exp` between", value1, value2, "exp");
            return (Criteria) this;
        }

        public Criteria andExpNotBetween(int value1, int value2) {
            addCriterion("`exp` not between", value1, value2, "exp");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("`comment` is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("`comment` is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("`comment` =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("`comment` <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("`comment` >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("`comment` >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("`comment` <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("`comment` <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("`comment` like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("`comment` not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("`comment` in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("`comment` not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("`comment` between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("`comment` not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andHasReleasedGuildIsNull() {
            addCriterion("has_released_guild is null");
            return (Criteria) this;
        }

        public Criteria andHasReleasedGuildIsNotNull() {
            addCriterion("has_released_guild is not null");
            return (Criteria) this;
        }

        public Criteria andHasReleasedGuildEqualTo(boolean value) {
            addCriterion("has_released_guild =", value, "hasReleasedGuild");
            return (Criteria) this;
        }

        public Criteria andHasReleasedGuildNotEqualTo(boolean value) {
            addCriterion("has_released_guild <>", value, "hasReleasedGuild");
            return (Criteria) this;
        }

        public Criteria andHasReleasedGuildGreaterThan(boolean value) {
            addCriterion("has_released_guild >", value, "hasReleasedGuild");
            return (Criteria) this;
        }

        public Criteria andHasReleasedGuildGreaterThanOrEqualTo(boolean value) {
            addCriterion("has_released_guild >=", value, "hasReleasedGuild");
            return (Criteria) this;
        }

        public Criteria andHasReleasedGuildLessThan(boolean value) {
            addCriterion("has_released_guild <", value, "hasReleasedGuild");
            return (Criteria) this;
        }

        public Criteria andHasReleasedGuildLessThanOrEqualTo(boolean value) {
            addCriterion("has_released_guild <=", value, "hasReleasedGuild");
            return (Criteria) this;
        }

        public Criteria andHasReleasedGuildIn(List<Boolean> values) {
            addCriterion("has_released_guild in", values, "hasReleasedGuild");
            return (Criteria) this;
        }

        public Criteria andHasReleasedGuildNotIn(List<Boolean> values) {
            addCriterion("has_released_guild not in", values, "hasReleasedGuild");
            return (Criteria) this;
        }

        public Criteria andHasReleasedGuildBetween(boolean value1, boolean value2) {
            addCriterion("has_released_guild between", value1, value2, "hasReleasedGuild");
            return (Criteria) this;
        }

        public Criteria andHasReleasedGuildNotBetween(boolean value1, boolean value2) {
            addCriterion("has_released_guild not between", value1, value2, "hasReleasedGuild");
            return (Criteria) this;
        }

        public Criteria andHasReleasedLeagueIsNull() {
            addCriterion("has_released_league is null");
            return (Criteria) this;
        }

        public Criteria andHasReleasedLeagueIsNotNull() {
            addCriterion("has_released_league is not null");
            return (Criteria) this;
        }

        public Criteria andHasReleasedLeagueEqualTo(boolean value) {
            addCriterion("has_released_league =", value, "hasReleasedLeague");
            return (Criteria) this;
        }

        public Criteria andHasReleasedLeagueNotEqualTo(boolean value) {
            addCriterion("has_released_league <>", value, "hasReleasedLeague");
            return (Criteria) this;
        }

        public Criteria andHasReleasedLeagueGreaterThan(boolean value) {
            addCriterion("has_released_league >", value, "hasReleasedLeague");
            return (Criteria) this;
        }

        public Criteria andHasReleasedLeagueGreaterThanOrEqualTo(boolean value) {
            addCriterion("has_released_league >=", value, "hasReleasedLeague");
            return (Criteria) this;
        }

        public Criteria andHasReleasedLeagueLessThan(boolean value) {
            addCriterion("has_released_league <", value, "hasReleasedLeague");
            return (Criteria) this;
        }

        public Criteria andHasReleasedLeagueLessThanOrEqualTo(boolean value) {
            addCriterion("has_released_league <=", value, "hasReleasedLeague");
            return (Criteria) this;
        }

        public Criteria andHasReleasedLeagueIn(List<Boolean> values) {
            addCriterion("has_released_league in", values, "hasReleasedLeague");
            return (Criteria) this;
        }

        public Criteria andHasReleasedLeagueNotIn(List<Boolean> values) {
            addCriterion("has_released_league not in", values, "hasReleasedLeague");
            return (Criteria) this;
        }

        public Criteria andHasReleasedLeagueBetween(boolean value1, boolean value2) {
            addCriterion("has_released_league between", value1, value2, "hasReleasedLeague");
            return (Criteria) this;
        }

        public Criteria andHasReleasedLeagueNotBetween(boolean value1, boolean value2) {
            addCriterion("has_released_league not between", value1, value2, "hasReleasedLeague");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPvpIsNull() {
            addCriterion("has_released_pvp is null");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPvpIsNotNull() {
            addCriterion("has_released_pvp is not null");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPvpEqualTo(boolean value) {
            addCriterion("has_released_pvp =", value, "hasReleasedPvp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPvpNotEqualTo(boolean value) {
            addCriterion("has_released_pvp <>", value, "hasReleasedPvp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPvpGreaterThan(boolean value) {
            addCriterion("has_released_pvp >", value, "hasReleasedPvp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPvpGreaterThanOrEqualTo(boolean value) {
            addCriterion("has_released_pvp >=", value, "hasReleasedPvp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPvpLessThan(boolean value) {
            addCriterion("has_released_pvp <", value, "hasReleasedPvp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPvpLessThanOrEqualTo(boolean value) {
            addCriterion("has_released_pvp <=", value, "hasReleasedPvp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPvpIn(List<Boolean> values) {
            addCriterion("has_released_pvp in", values, "hasReleasedPvp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPvpNotIn(List<Boolean> values) {
            addCriterion("has_released_pvp not in", values, "hasReleasedPvp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPvpBetween(boolean value1, boolean value2) {
            addCriterion("has_released_pvp between", value1, value2, "hasReleasedPvp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPvpNotBetween(boolean value1, boolean value2) {
            addCriterion("has_released_pvp not between", value1, value2, "hasReleasedPvp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedArousalIsNull() {
            addCriterion("has_released_arousal is null");
            return (Criteria) this;
        }

        public Criteria andHasReleasedArousalIsNotNull() {
            addCriterion("has_released_arousal is not null");
            return (Criteria) this;
        }

        public Criteria andHasReleasedArousalEqualTo(boolean value) {
            addCriterion("has_released_arousal =", value, "hasReleasedArousal");
            return (Criteria) this;
        }

        public Criteria andHasReleasedArousalNotEqualTo(boolean value) {
            addCriterion("has_released_arousal <>", value, "hasReleasedArousal");
            return (Criteria) this;
        }

        public Criteria andHasReleasedArousalGreaterThan(boolean value) {
            addCriterion("has_released_arousal >", value, "hasReleasedArousal");
            return (Criteria) this;
        }

        public Criteria andHasReleasedArousalGreaterThanOrEqualTo(boolean value) {
            addCriterion("has_released_arousal >=", value, "hasReleasedArousal");
            return (Criteria) this;
        }

        public Criteria andHasReleasedArousalLessThan(boolean value) {
            addCriterion("has_released_arousal <", value, "hasReleasedArousal");
            return (Criteria) this;
        }

        public Criteria andHasReleasedArousalLessThanOrEqualTo(boolean value) {
            addCriterion("has_released_arousal <=", value, "hasReleasedArousal");
            return (Criteria) this;
        }

        public Criteria andHasReleasedArousalIn(List<Boolean> values) {
            addCriterion("has_released_arousal in", values, "hasReleasedArousal");
            return (Criteria) this;
        }

        public Criteria andHasReleasedArousalNotIn(List<Boolean> values) {
            addCriterion("has_released_arousal not in", values, "hasReleasedArousal");
            return (Criteria) this;
        }

        public Criteria andHasReleasedArousalBetween(boolean value1, boolean value2) {
            addCriterion("has_released_arousal between", value1, value2, "hasReleasedArousal");
            return (Criteria) this;
        }

        public Criteria andHasReleasedArousalNotBetween(boolean value1, boolean value2) {
            addCriterion("has_released_arousal not between", value1, value2, "hasReleasedArousal");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPowerUpIsNull() {
            addCriterion("has_released_power_up is null");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPowerUpIsNotNull() {
            addCriterion("has_released_power_up is not null");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPowerUpEqualTo(boolean value) {
            addCriterion("has_released_power_up =", value, "hasReleasedPowerUp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPowerUpNotEqualTo(boolean value) {
            addCriterion("has_released_power_up <>", value, "hasReleasedPowerUp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPowerUpGreaterThan(boolean value) {
            addCriterion("has_released_power_up >", value, "hasReleasedPowerUp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPowerUpGreaterThanOrEqualTo(boolean value) {
            addCriterion("has_released_power_up >=", value, "hasReleasedPowerUp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPowerUpLessThan(boolean value) {
            addCriterion("has_released_power_up <", value, "hasReleasedPowerUp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPowerUpLessThanOrEqualTo(boolean value) {
            addCriterion("has_released_power_up <=", value, "hasReleasedPowerUp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPowerUpIn(List<Boolean> values) {
            addCriterion("has_released_power_up in", values, "hasReleasedPowerUp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPowerUpNotIn(List<Boolean> values) {
            addCriterion("has_released_power_up not in", values, "hasReleasedPowerUp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPowerUpBetween(boolean value1, boolean value2) {
            addCriterion("has_released_power_up between", value1, value2, "hasReleasedPowerUp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedPowerUpNotBetween(boolean value1, boolean value2) {
            addCriterion("has_released_power_up not between", value1, value2, "hasReleasedPowerUp");
            return (Criteria) this;
        }

        public Criteria andHasReleasedInheritIsNull() {
            addCriterion("has_released_inherit is null");
            return (Criteria) this;
        }

        public Criteria andHasReleasedInheritIsNotNull() {
            addCriterion("has_released_inherit is not null");
            return (Criteria) this;
        }

        public Criteria andHasReleasedInheritEqualTo(boolean value) {
            addCriterion("has_released_inherit =", value, "hasReleasedInherit");
            return (Criteria) this;
        }

        public Criteria andHasReleasedInheritNotEqualTo(boolean value) {
            addCriterion("has_released_inherit <>", value, "hasReleasedInherit");
            return (Criteria) this;
        }

        public Criteria andHasReleasedInheritGreaterThan(boolean value) {
            addCriterion("has_released_inherit >", value, "hasReleasedInherit");
            return (Criteria) this;
        }

        public Criteria andHasReleasedInheritGreaterThanOrEqualTo(boolean value) {
            addCriterion("has_released_inherit >=", value, "hasReleasedInherit");
            return (Criteria) this;
        }

        public Criteria andHasReleasedInheritLessThan(boolean value) {
            addCriterion("has_released_inherit <", value, "hasReleasedInherit");
            return (Criteria) this;
        }

        public Criteria andHasReleasedInheritLessThanOrEqualTo(boolean value) {
            addCriterion("has_released_inherit <=", value, "hasReleasedInherit");
            return (Criteria) this;
        }

        public Criteria andHasReleasedInheritIn(List<Boolean> values) {
            addCriterion("has_released_inherit in", values, "hasReleasedInherit");
            return (Criteria) this;
        }

        public Criteria andHasReleasedInheritNotIn(List<Boolean> values) {
            addCriterion("has_released_inherit not in", values, "hasReleasedInherit");
            return (Criteria) this;
        }

        public Criteria andHasReleasedInheritBetween(boolean value1, boolean value2) {
            addCriterion("has_released_inherit between", value1, value2, "hasReleasedInherit");
            return (Criteria) this;
        }

        public Criteria andHasReleasedInheritNotBetween(boolean value1, boolean value2) {
            addCriterion("has_released_inherit not between", value1, value2, "hasReleasedInherit");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdIsNull() {
            addCriterion("pvp_grade_id is null");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdIsNotNull() {
            addCriterion("pvp_grade_id is not null");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdEqualTo(int value) {
            addCriterion("pvp_grade_id =", value, "pvpGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdNotEqualTo(int value) {
            addCriterion("pvp_grade_id <>", value, "pvpGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdGreaterThan(int value) {
            addCriterion("pvp_grade_id >", value, "pvpGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdGreaterThanOrEqualTo(int value) {
            addCriterion("pvp_grade_id >=", value, "pvpGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdLessThan(int value) {
            addCriterion("pvp_grade_id <", value, "pvpGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdLessThanOrEqualTo(int value) {
            addCriterion("pvp_grade_id <=", value, "pvpGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdIn(List<Integer> values) {
            addCriterion("pvp_grade_id in", values, "pvpGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdNotIn(List<Integer> values) {
            addCriterion("pvp_grade_id not in", values, "pvpGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdBetween(int value1, int value2) {
            addCriterion("pvp_grade_id between", value1, value2, "pvpGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdNotBetween(int value1, int value2) {
            addCriterion("pvp_grade_id not between", value1, value2, "pvpGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdUpdatedAtIsNull() {
            addCriterion("pvp_grade_id_updated_at is null");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdUpdatedAtIsNotNull() {
            addCriterion("pvp_grade_id_updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdUpdatedAtEqualTo(int value) {
            addCriterion("pvp_grade_id_updated_at =", value, "pvpGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdUpdatedAtNotEqualTo(int value) {
            addCriterion("pvp_grade_id_updated_at <>", value, "pvpGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdUpdatedAtGreaterThan(int value) {
            addCriterion("pvp_grade_id_updated_at >", value, "pvpGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdUpdatedAtGreaterThanOrEqualTo(int value) {
            addCriterion("pvp_grade_id_updated_at >=", value, "pvpGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdUpdatedAtLessThan(int value) {
            addCriterion("pvp_grade_id_updated_at <", value, "pvpGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdUpdatedAtLessThanOrEqualTo(int value) {
            addCriterion("pvp_grade_id_updated_at <=", value, "pvpGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdUpdatedAtIn(List<Integer> values) {
            addCriterion("pvp_grade_id_updated_at in", values, "pvpGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdUpdatedAtNotIn(List<Integer> values) {
            addCriterion("pvp_grade_id_updated_at not in", values, "pvpGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdUpdatedAtBetween(int value1, int value2) {
            addCriterion("pvp_grade_id_updated_at between", value1, value2, "pvpGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpGradeIdUpdatedAtNotBetween(int value1, int value2) {
            addCriterion("pvp_grade_id_updated_at not between", value1, value2, "pvpGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdIsNull() {
            addCriterion("pvp_standard_grade_id is null");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdIsNotNull() {
            addCriterion("pvp_standard_grade_id is not null");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdEqualTo(int value) {
            addCriterion("pvp_standard_grade_id =", value, "pvpStandardGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdNotEqualTo(int value) {
            addCriterion("pvp_standard_grade_id <>", value, "pvpStandardGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdGreaterThan(int value) {
            addCriterion("pvp_standard_grade_id >", value, "pvpStandardGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdGreaterThanOrEqualTo(int value) {
            addCriterion("pvp_standard_grade_id >=", value, "pvpStandardGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdLessThan(int value) {
            addCriterion("pvp_standard_grade_id <", value, "pvpStandardGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdLessThanOrEqualTo(int value) {
            addCriterion("pvp_standard_grade_id <=", value, "pvpStandardGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdIn(List<Integer> values) {
            addCriterion("pvp_standard_grade_id in", values, "pvpStandardGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdNotIn(List<Integer> values) {
            addCriterion("pvp_standard_grade_id not in", values, "pvpStandardGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdBetween(int value1, int value2) {
            addCriterion("pvp_standard_grade_id between", value1, value2, "pvpStandardGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdNotBetween(int value1, int value2) {
            addCriterion("pvp_standard_grade_id not between", value1, value2, "pvpStandardGradeId");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdUpdatedAtIsNull() {
            addCriterion("pvp_standard_grade_id_updated_at is null");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdUpdatedAtIsNotNull() {
            addCriterion("pvp_standard_grade_id_updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdUpdatedAtEqualTo(int value) {
            addCriterion("pvp_standard_grade_id_updated_at =", value, "pvpStandardGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdUpdatedAtNotEqualTo(int value) {
            addCriterion("pvp_standard_grade_id_updated_at <>", value, "pvpStandardGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdUpdatedAtGreaterThan(int value) {
            addCriterion("pvp_standard_grade_id_updated_at >", value, "pvpStandardGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdUpdatedAtGreaterThanOrEqualTo(int value) {
            addCriterion("pvp_standard_grade_id_updated_at >=", value, "pvpStandardGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdUpdatedAtLessThan(int value) {
            addCriterion("pvp_standard_grade_id_updated_at <", value, "pvpStandardGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdUpdatedAtLessThanOrEqualTo(int value) {
            addCriterion("pvp_standard_grade_id_updated_at <=", value, "pvpStandardGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdUpdatedAtIn(List<Integer> values) {
            addCriterion("pvp_standard_grade_id_updated_at in", values, "pvpStandardGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdUpdatedAtNotIn(List<Integer> values) {
            addCriterion("pvp_standard_grade_id_updated_at not in", values, "pvpStandardGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdUpdatedAtBetween(int value1, int value2) {
            addCriterion("pvp_standard_grade_id_updated_at between", value1, value2, "pvpStandardGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andPvpStandardGradeIdUpdatedAtNotBetween(int value1, int value2) {
            addCriterion("pvp_standard_grade_id_updated_at not between", value1, value2, "pvpStandardGradeIdUpdatedAt");
            return (Criteria) this;
        }

        public Criteria andTutorialPhaseIsNull() {
            addCriterion("tutorial_phase is null");
            return (Criteria) this;
        }

        public Criteria andTutorialPhaseIsNotNull() {
            addCriterion("tutorial_phase is not null");
            return (Criteria) this;
        }

        public Criteria andTutorialPhaseEqualTo(byte value) {
            addCriterion("tutorial_phase =", value, "tutorialPhase");
            return (Criteria) this;
        }

        public Criteria andTutorialPhaseNotEqualTo(byte value) {
            addCriterion("tutorial_phase <>", value, "tutorialPhase");
            return (Criteria) this;
        }

        public Criteria andTutorialPhaseGreaterThan(byte value) {
            addCriterion("tutorial_phase >", value, "tutorialPhase");
            return (Criteria) this;
        }

        public Criteria andTutorialPhaseGreaterThanOrEqualTo(byte value) {
            addCriterion("tutorial_phase >=", value, "tutorialPhase");
            return (Criteria) this;
        }

        public Criteria andTutorialPhaseLessThan(byte value) {
            addCriterion("tutorial_phase <", value, "tutorialPhase");
            return (Criteria) this;
        }

        public Criteria andTutorialPhaseLessThanOrEqualTo(byte value) {
            addCriterion("tutorial_phase <=", value, "tutorialPhase");
            return (Criteria) this;
        }

        public Criteria andTutorialPhaseIn(List<Byte> values) {
            addCriterion("tutorial_phase in", values, "tutorialPhase");
            return (Criteria) this;
        }

        public Criteria andTutorialPhaseNotIn(List<Byte> values) {
            addCriterion("tutorial_phase not in", values, "tutorialPhase");
            return (Criteria) this;
        }

        public Criteria andTutorialPhaseBetween(byte value1, byte value2) {
            addCriterion("tutorial_phase between", value1, value2, "tutorialPhase");
            return (Criteria) this;
        }

        public Criteria andTutorialPhaseNotBetween(byte value1, byte value2) {
            addCriterion("tutorial_phase not between", value1, value2, "tutorialPhase");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNull() {
            addCriterion("team_name is null");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNotNull() {
            addCriterion("team_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeamNameEqualTo(String value) {
            addCriterion("team_name =", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotEqualTo(String value) {
            addCriterion("team_name <>", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThan(String value) {
            addCriterion("team_name >", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThanOrEqualTo(String value) {
            addCriterion("team_name >=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThan(String value) {
            addCriterion("team_name <", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThanOrEqualTo(String value) {
            addCriterion("team_name <=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLike(String value) {
            addCriterion("team_name like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotLike(String value) {
            addCriterion("team_name not like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameIn(List<String> values) {
            addCriterion("team_name in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotIn(List<String> values) {
            addCriterion("team_name not in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameBetween(String value1, String value2) {
            addCriterion("team_name between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotBetween(String value1, String value2) {
            addCriterion("team_name not between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andLanguageCodeIsNull() {
            addCriterion("language_code is null");
            return (Criteria) this;
        }

        public Criteria andLanguageCodeIsNotNull() {
            addCriterion("language_code is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageCodeEqualTo(byte value) {
            addCriterion("language_code =", value, "languageCode");
            return (Criteria) this;
        }

        public Criteria andLanguageCodeNotEqualTo(byte value) {
            addCriterion("language_code <>", value, "languageCode");
            return (Criteria) this;
        }

        public Criteria andLanguageCodeGreaterThan(byte value) {
            addCriterion("language_code >", value, "languageCode");
            return (Criteria) this;
        }

        public Criteria andLanguageCodeGreaterThanOrEqualTo(byte value) {
            addCriterion("language_code >=", value, "languageCode");
            return (Criteria) this;
        }

        public Criteria andLanguageCodeLessThan(byte value) {
            addCriterion("language_code <", value, "languageCode");
            return (Criteria) this;
        }

        public Criteria andLanguageCodeLessThanOrEqualTo(byte value) {
            addCriterion("language_code <=", value, "languageCode");
            return (Criteria) this;
        }

        public Criteria andLanguageCodeIn(List<Byte> values) {
            addCriterion("language_code in", values, "languageCode");
            return (Criteria) this;
        }

        public Criteria andLanguageCodeNotIn(List<Byte> values) {
            addCriterion("language_code not in", values, "languageCode");
            return (Criteria) this;
        }

        public Criteria andLanguageCodeBetween(byte value1, byte value2) {
            addCriterion("language_code between", value1, value2, "languageCode");
            return (Criteria) this;
        }

        public Criteria andLanguageCodeNotBetween(byte value1, byte value2) {
            addCriterion("language_code not between", value1, value2, "languageCode");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(int value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(int value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(int value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(int value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(int value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(int value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Integer> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Integer> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(int value1, int value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(int value1, int value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(int value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(int value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(int value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(int value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(int value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(int value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Integer> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Integer> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(int value1, int value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(int value1, int value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andTotalPayAmountIsNull() {
            addCriterion("total_pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalPayAmountIsNotNull() {
            addCriterion("total_pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPayAmountEqualTo(int value) {
            addCriterion("total_pay_amount =", value, "totalPayAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPayAmountNotEqualTo(int value) {
            addCriterion("total_pay_amount <>", value, "totalPayAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPayAmountGreaterThan(int value) {
            addCriterion("total_pay_amount >", value, "totalPayAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPayAmountGreaterThanOrEqualTo(int value) {
            addCriterion("total_pay_amount >=", value, "totalPayAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPayAmountLessThan(int value) {
            addCriterion("total_pay_amount <", value, "totalPayAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPayAmountLessThanOrEqualTo(int value) {
            addCriterion("total_pay_amount <=", value, "totalPayAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPayAmountIn(List<Integer> values) {
            addCriterion("total_pay_amount in", values, "totalPayAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPayAmountNotIn(List<Integer> values) {
            addCriterion("total_pay_amount not in", values, "totalPayAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPayAmountBetween(int value1, int value2) {
            addCriterion("total_pay_amount between", value1, value2, "totalPayAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPayAmountNotBetween(int value1, int value2) {
            addCriterion("total_pay_amount not between", value1, value2, "totalPayAmount");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}