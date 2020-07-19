package com.ssmshiro.entity;

import java.util.ArrayList;
import java.util.List;

public class CurworkloadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CurworkloadExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andXqIsNull() {
            addCriterion("xq is null");
            return (Criteria) this;
        }

        public Criteria andXqIsNotNull() {
            addCriterion("xq is not null");
            return (Criteria) this;
        }

        public Criteria andXqEqualTo(Integer value) {
            addCriterion("xq =", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqNotEqualTo(Integer value) {
            addCriterion("xq <>", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqGreaterThan(Integer value) {
            addCriterion("xq >", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqGreaterThanOrEqualTo(Integer value) {
            addCriterion("xq >=", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqLessThan(Integer value) {
            addCriterion("xq <", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqLessThanOrEqualTo(Integer value) {
            addCriterion("xq <=", value, "xq");
            return (Criteria) this;
        }

        public Criteria andXqIn(List<Integer> values) {
            addCriterion("xq in", values, "xq");
            return (Criteria) this;
        }

        public Criteria andXqNotIn(List<Integer> values) {
            addCriterion("xq not in", values, "xq");
            return (Criteria) this;
        }

        public Criteria andXqBetween(Integer value1, Integer value2) {
            addCriterion("xq between", value1, value2, "xq");
            return (Criteria) this;
        }

        public Criteria andXqNotBetween(Integer value1, Integer value2) {
            addCriterion("xq not between", value1, value2, "xq");
            return (Criteria) this;
        }

        public Criteria andKchIsNull() {
            addCriterion("kch is null");
            return (Criteria) this;
        }

        public Criteria andKchIsNotNull() {
            addCriterion("kch is not null");
            return (Criteria) this;
        }

        public Criteria andKchEqualTo(String value) {
            addCriterion("kch =", value, "kch");
            return (Criteria) this;
        }

        public Criteria andKchNotEqualTo(String value) {
            addCriterion("kch <>", value, "kch");
            return (Criteria) this;
        }

        public Criteria andKchGreaterThan(String value) {
            addCriterion("kch >", value, "kch");
            return (Criteria) this;
        }

        public Criteria andKchGreaterThanOrEqualTo(String value) {
            addCriterion("kch >=", value, "kch");
            return (Criteria) this;
        }

        public Criteria andKchLessThan(String value) {
            addCriterion("kch <", value, "kch");
            return (Criteria) this;
        }

        public Criteria andKchLessThanOrEqualTo(String value) {
            addCriterion("kch <=", value, "kch");
            return (Criteria) this;
        }

        public Criteria andKchLike(String value) {
            addCriterion("kch like", value, "kch");
            return (Criteria) this;
        }

        public Criteria andKchNotLike(String value) {
            addCriterion("kch not like", value, "kch");
            return (Criteria) this;
        }

        public Criteria andKchIn(List<String> values) {
            addCriterion("kch in", values, "kch");
            return (Criteria) this;
        }

        public Criteria andKchNotIn(List<String> values) {
            addCriterion("kch not in", values, "kch");
            return (Criteria) this;
        }

        public Criteria andKchBetween(String value1, String value2) {
            addCriterion("kch between", value1, value2, "kch");
            return (Criteria) this;
        }

        public Criteria andKchNotBetween(String value1, String value2) {
            addCriterion("kch not between", value1, value2, "kch");
            return (Criteria) this;
        }

        public Criteria andKxhIsNull() {
            addCriterion("kxh is null");
            return (Criteria) this;
        }

        public Criteria andKxhIsNotNull() {
            addCriterion("kxh is not null");
            return (Criteria) this;
        }

        public Criteria andKxhEqualTo(String value) {
            addCriterion("kxh =", value, "kxh");
            return (Criteria) this;
        }

        public Criteria andKxhNotEqualTo(String value) {
            addCriterion("kxh <>", value, "kxh");
            return (Criteria) this;
        }

        public Criteria andKxhGreaterThan(String value) {
            addCriterion("kxh >", value, "kxh");
            return (Criteria) this;
        }

        public Criteria andKxhGreaterThanOrEqualTo(String value) {
            addCriterion("kxh >=", value, "kxh");
            return (Criteria) this;
        }

        public Criteria andKxhLessThan(String value) {
            addCriterion("kxh <", value, "kxh");
            return (Criteria) this;
        }

        public Criteria andKxhLessThanOrEqualTo(String value) {
            addCriterion("kxh <=", value, "kxh");
            return (Criteria) this;
        }

        public Criteria andKxhLike(String value) {
            addCriterion("kxh like", value, "kxh");
            return (Criteria) this;
        }

        public Criteria andKxhNotLike(String value) {
            addCriterion("kxh not like", value, "kxh");
            return (Criteria) this;
        }

        public Criteria andKxhIn(List<String> values) {
            addCriterion("kxh in", values, "kxh");
            return (Criteria) this;
        }

        public Criteria andKxhNotIn(List<String> values) {
            addCriterion("kxh not in", values, "kxh");
            return (Criteria) this;
        }

        public Criteria andKxhBetween(String value1, String value2) {
            addCriterion("kxh between", value1, value2, "kxh");
            return (Criteria) this;
        }

        public Criteria andKxhNotBetween(String value1, String value2) {
            addCriterion("kxh not between", value1, value2, "kxh");
            return (Criteria) this;
        }

        public Criteria andKcmIsNull() {
            addCriterion("kcm is null");
            return (Criteria) this;
        }

        public Criteria andKcmIsNotNull() {
            addCriterion("kcm is not null");
            return (Criteria) this;
        }

        public Criteria andKcmEqualTo(String value) {
            addCriterion("kcm =", value, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmNotEqualTo(String value) {
            addCriterion("kcm <>", value, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmGreaterThan(String value) {
            addCriterion("kcm >", value, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmGreaterThanOrEqualTo(String value) {
            addCriterion("kcm >=", value, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmLessThan(String value) {
            addCriterion("kcm <", value, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmLessThanOrEqualTo(String value) {
            addCriterion("kcm <=", value, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmLike(String value) {
            addCriterion("kcm like", value, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmNotLike(String value) {
            addCriterion("kcm not like", value, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmIn(List<String> values) {
            addCriterion("kcm in", values, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmNotIn(List<String> values) {
            addCriterion("kcm not in", values, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmBetween(String value1, String value2) {
            addCriterion("kcm between", value1, value2, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmNotBetween(String value1, String value2) {
            addCriterion("kcm not between", value1, value2, "kcm");
            return (Criteria) this;
        }

        public Criteria andSklsIsNull() {
            addCriterion("skls is null");
            return (Criteria) this;
        }

        public Criteria andSklsIsNotNull() {
            addCriterion("skls is not null");
            return (Criteria) this;
        }

        public Criteria andSklsEqualTo(String value) {
            addCriterion("skls =", value, "skls");
            return (Criteria) this;
        }

        public Criteria andSklsNotEqualTo(String value) {
            addCriterion("skls <>", value, "skls");
            return (Criteria) this;
        }

        public Criteria andSklsGreaterThan(String value) {
            addCriterion("skls >", value, "skls");
            return (Criteria) this;
        }

        public Criteria andSklsGreaterThanOrEqualTo(String value) {
            addCriterion("skls >=", value, "skls");
            return (Criteria) this;
        }

        public Criteria andSklsLessThan(String value) {
            addCriterion("skls <", value, "skls");
            return (Criteria) this;
        }

        public Criteria andSklsLessThanOrEqualTo(String value) {
            addCriterion("skls <=", value, "skls");
            return (Criteria) this;
        }

        public Criteria andSklsLike(String value) {
            addCriterion("skls like", value, "skls");
            return (Criteria) this;
        }

        public Criteria andSklsNotLike(String value) {
            addCriterion("skls not like", value, "skls");
            return (Criteria) this;
        }

        public Criteria andSklsIn(List<String> values) {
            addCriterion("skls in", values, "skls");
            return (Criteria) this;
        }

        public Criteria andSklsNotIn(List<String> values) {
            addCriterion("skls not in", values, "skls");
            return (Criteria) this;
        }

        public Criteria andSklsBetween(String value1, String value2) {
            addCriterion("skls between", value1, value2, "skls");
            return (Criteria) this;
        }

        public Criteria andSklsNotBetween(String value1, String value2) {
            addCriterion("skls not between", value1, value2, "skls");
            return (Criteria) this;
        }

        public Criteria andLszcIsNull() {
            addCriterion("lszc is null");
            return (Criteria) this;
        }

        public Criteria andLszcIsNotNull() {
            addCriterion("lszc is not null");
            return (Criteria) this;
        }

        public Criteria andLszcEqualTo(String value) {
            addCriterion("lszc =", value, "lszc");
            return (Criteria) this;
        }

        public Criteria andLszcNotEqualTo(String value) {
            addCriterion("lszc <>", value, "lszc");
            return (Criteria) this;
        }

        public Criteria andLszcGreaterThan(String value) {
            addCriterion("lszc >", value, "lszc");
            return (Criteria) this;
        }

        public Criteria andLszcGreaterThanOrEqualTo(String value) {
            addCriterion("lszc >=", value, "lszc");
            return (Criteria) this;
        }

        public Criteria andLszcLessThan(String value) {
            addCriterion("lszc <", value, "lszc");
            return (Criteria) this;
        }

        public Criteria andLszcLessThanOrEqualTo(String value) {
            addCriterion("lszc <=", value, "lszc");
            return (Criteria) this;
        }

        public Criteria andLszcLike(String value) {
            addCriterion("lszc like", value, "lszc");
            return (Criteria) this;
        }

        public Criteria andLszcNotLike(String value) {
            addCriterion("lszc not like", value, "lszc");
            return (Criteria) this;
        }

        public Criteria andLszcIn(List<String> values) {
            addCriterion("lszc in", values, "lszc");
            return (Criteria) this;
        }

        public Criteria andLszcNotIn(List<String> values) {
            addCriterion("lszc not in", values, "lszc");
            return (Criteria) this;
        }

        public Criteria andLszcBetween(String value1, String value2) {
            addCriterion("lszc between", value1, value2, "lszc");
            return (Criteria) this;
        }

        public Criteria andLszcNotBetween(String value1, String value2) {
            addCriterion("lszc not between", value1, value2, "lszc");
            return (Criteria) this;
        }

        public Criteria andYxidIsNull() {
            addCriterion("yxid is null");
            return (Criteria) this;
        }

        public Criteria andYxidIsNotNull() {
            addCriterion("yxid is not null");
            return (Criteria) this;
        }

        public Criteria andYxidEqualTo(Integer value) {
            addCriterion("yxid =", value, "yxid");
            return (Criteria) this;
        }

        public Criteria andYxidNotEqualTo(Integer value) {
            addCriterion("yxid <>", value, "yxid");
            return (Criteria) this;
        }

        public Criteria andYxidGreaterThan(Integer value) {
            addCriterion("yxid >", value, "yxid");
            return (Criteria) this;
        }

        public Criteria andYxidGreaterThanOrEqualTo(Integer value) {
            addCriterion("yxid >=", value, "yxid");
            return (Criteria) this;
        }

        public Criteria andYxidLessThan(Integer value) {
            addCriterion("yxid <", value, "yxid");
            return (Criteria) this;
        }

        public Criteria andYxidLessThanOrEqualTo(Integer value) {
            addCriterion("yxid <=", value, "yxid");
            return (Criteria) this;
        }

        public Criteria andYxidIn(List<Integer> values) {
            addCriterion("yxid in", values, "yxid");
            return (Criteria) this;
        }

        public Criteria andYxidNotIn(List<Integer> values) {
            addCriterion("yxid not in", values, "yxid");
            return (Criteria) this;
        }

        public Criteria andYxidBetween(Integer value1, Integer value2) {
            addCriterion("yxid between", value1, value2, "yxid");
            return (Criteria) this;
        }

        public Criteria andYxidNotBetween(Integer value1, Integer value2) {
            addCriterion("yxid not between", value1, value2, "yxid");
            return (Criteria) this;
        }

        public Criteria andKcsxIsNull() {
            addCriterion("kcsx is null");
            return (Criteria) this;
        }

        public Criteria andKcsxIsNotNull() {
            addCriterion("kcsx is not null");
            return (Criteria) this;
        }

        public Criteria andKcsxEqualTo(String value) {
            addCriterion("kcsx =", value, "kcsx");
            return (Criteria) this;
        }

        public Criteria andKcsxNotEqualTo(String value) {
            addCriterion("kcsx <>", value, "kcsx");
            return (Criteria) this;
        }

        public Criteria andKcsxGreaterThan(String value) {
            addCriterion("kcsx >", value, "kcsx");
            return (Criteria) this;
        }

        public Criteria andKcsxGreaterThanOrEqualTo(String value) {
            addCriterion("kcsx >=", value, "kcsx");
            return (Criteria) this;
        }

        public Criteria andKcsxLessThan(String value) {
            addCriterion("kcsx <", value, "kcsx");
            return (Criteria) this;
        }

        public Criteria andKcsxLessThanOrEqualTo(String value) {
            addCriterion("kcsx <=", value, "kcsx");
            return (Criteria) this;
        }

        public Criteria andKcsxLike(String value) {
            addCriterion("kcsx like", value, "kcsx");
            return (Criteria) this;
        }

        public Criteria andKcsxNotLike(String value) {
            addCriterion("kcsx not like", value, "kcsx");
            return (Criteria) this;
        }

        public Criteria andKcsxIn(List<String> values) {
            addCriterion("kcsx in", values, "kcsx");
            return (Criteria) this;
        }

        public Criteria andKcsxNotIn(List<String> values) {
            addCriterion("kcsx not in", values, "kcsx");
            return (Criteria) this;
        }

        public Criteria andKcsxBetween(String value1, String value2) {
            addCriterion("kcsx between", value1, value2, "kcsx");
            return (Criteria) this;
        }

        public Criteria andKcsxNotBetween(String value1, String value2) {
            addCriterion("kcsx not between", value1, value2, "kcsx");
            return (Criteria) this;
        }

        public Criteria andBjmcIsNull() {
            addCriterion("bjmc is null");
            return (Criteria) this;
        }

        public Criteria andBjmcIsNotNull() {
            addCriterion("bjmc is not null");
            return (Criteria) this;
        }

        public Criteria andBjmcEqualTo(String value) {
            addCriterion("bjmc =", value, "bjmc");
            return (Criteria) this;
        }

        public Criteria andBjmcNotEqualTo(String value) {
            addCriterion("bjmc <>", value, "bjmc");
            return (Criteria) this;
        }

        public Criteria andBjmcGreaterThan(String value) {
            addCriterion("bjmc >", value, "bjmc");
            return (Criteria) this;
        }

        public Criteria andBjmcGreaterThanOrEqualTo(String value) {
            addCriterion("bjmc >=", value, "bjmc");
            return (Criteria) this;
        }

        public Criteria andBjmcLessThan(String value) {
            addCriterion("bjmc <", value, "bjmc");
            return (Criteria) this;
        }

        public Criteria andBjmcLessThanOrEqualTo(String value) {
            addCriterion("bjmc <=", value, "bjmc");
            return (Criteria) this;
        }

        public Criteria andBjmcLike(String value) {
            addCriterion("bjmc like", value, "bjmc");
            return (Criteria) this;
        }

        public Criteria andBjmcNotLike(String value) {
            addCriterion("bjmc not like", value, "bjmc");
            return (Criteria) this;
        }

        public Criteria andBjmcIn(List<String> values) {
            addCriterion("bjmc in", values, "bjmc");
            return (Criteria) this;
        }

        public Criteria andBjmcNotIn(List<String> values) {
            addCriterion("bjmc not in", values, "bjmc");
            return (Criteria) this;
        }

        public Criteria andBjmcBetween(String value1, String value2) {
            addCriterion("bjmc between", value1, value2, "bjmc");
            return (Criteria) this;
        }

        public Criteria andBjmcNotBetween(String value1, String value2) {
            addCriterion("bjmc not between", value1, value2, "bjmc");
            return (Criteria) this;
        }

        public Criteria andKrlIsNull() {
            addCriterion("krl is null");
            return (Criteria) this;
        }

        public Criteria andKrlIsNotNull() {
            addCriterion("krl is not null");
            return (Criteria) this;
        }

        public Criteria andKrlEqualTo(Integer value) {
            addCriterion("krl =", value, "krl");
            return (Criteria) this;
        }

        public Criteria andKrlNotEqualTo(Integer value) {
            addCriterion("krl <>", value, "krl");
            return (Criteria) this;
        }

        public Criteria andKrlGreaterThan(Integer value) {
            addCriterion("krl >", value, "krl");
            return (Criteria) this;
        }

        public Criteria andKrlGreaterThanOrEqualTo(Integer value) {
            addCriterion("krl >=", value, "krl");
            return (Criteria) this;
        }

        public Criteria andKrlLessThan(Integer value) {
            addCriterion("krl <", value, "krl");
            return (Criteria) this;
        }

        public Criteria andKrlLessThanOrEqualTo(Integer value) {
            addCriterion("krl <=", value, "krl");
            return (Criteria) this;
        }

        public Criteria andKrlIn(List<Integer> values) {
            addCriterion("krl in", values, "krl");
            return (Criteria) this;
        }

        public Criteria andKrlNotIn(List<Integer> values) {
            addCriterion("krl not in", values, "krl");
            return (Criteria) this;
        }

        public Criteria andKrlBetween(Integer value1, Integer value2) {
            addCriterion("krl between", value1, value2, "krl");
            return (Criteria) this;
        }

        public Criteria andKrlNotBetween(Integer value1, Integer value2) {
            addCriterion("krl not between", value1, value2, "krl");
            return (Criteria) this;
        }

        public Criteria andXkrsIsNull() {
            addCriterion("xkrs is null");
            return (Criteria) this;
        }

        public Criteria andXkrsIsNotNull() {
            addCriterion("xkrs is not null");
            return (Criteria) this;
        }

        public Criteria andXkrsEqualTo(Integer value) {
            addCriterion("xkrs =", value, "xkrs");
            return (Criteria) this;
        }

        public Criteria andXkrsNotEqualTo(Integer value) {
            addCriterion("xkrs <>", value, "xkrs");
            return (Criteria) this;
        }

        public Criteria andXkrsGreaterThan(Integer value) {
            addCriterion("xkrs >", value, "xkrs");
            return (Criteria) this;
        }

        public Criteria andXkrsGreaterThanOrEqualTo(Integer value) {
            addCriterion("xkrs >=", value, "xkrs");
            return (Criteria) this;
        }

        public Criteria andXkrsLessThan(Integer value) {
            addCriterion("xkrs <", value, "xkrs");
            return (Criteria) this;
        }

        public Criteria andXkrsLessThanOrEqualTo(Integer value) {
            addCriterion("xkrs <=", value, "xkrs");
            return (Criteria) this;
        }

        public Criteria andXkrsIn(List<Integer> values) {
            addCriterion("xkrs in", values, "xkrs");
            return (Criteria) this;
        }

        public Criteria andXkrsNotIn(List<Integer> values) {
            addCriterion("xkrs not in", values, "xkrs");
            return (Criteria) this;
        }

        public Criteria andXkrsBetween(Integer value1, Integer value2) {
            addCriterion("xkrs between", value1, value2, "xkrs");
            return (Criteria) this;
        }

        public Criteria andXkrsNotBetween(Integer value1, Integer value2) {
            addCriterion("xkrs not between", value1, value2, "xkrs");
            return (Criteria) this;
        }

        public Criteria andZxsIsNull() {
            addCriterion("zxs is null");
            return (Criteria) this;
        }

        public Criteria andZxsIsNotNull() {
            addCriterion("zxs is not null");
            return (Criteria) this;
        }

        public Criteria andZxsEqualTo(Integer value) {
            addCriterion("zxs =", value, "zxs");
            return (Criteria) this;
        }

        public Criteria andZxsNotEqualTo(Integer value) {
            addCriterion("zxs <>", value, "zxs");
            return (Criteria) this;
        }

        public Criteria andZxsGreaterThan(Integer value) {
            addCriterion("zxs >", value, "zxs");
            return (Criteria) this;
        }

        public Criteria andZxsGreaterThanOrEqualTo(Integer value) {
            addCriterion("zxs >=", value, "zxs");
            return (Criteria) this;
        }

        public Criteria andZxsLessThan(Integer value) {
            addCriterion("zxs <", value, "zxs");
            return (Criteria) this;
        }

        public Criteria andZxsLessThanOrEqualTo(Integer value) {
            addCriterion("zxs <=", value, "zxs");
            return (Criteria) this;
        }

        public Criteria andZxsIn(List<Integer> values) {
            addCriterion("zxs in", values, "zxs");
            return (Criteria) this;
        }

        public Criteria andZxsNotIn(List<Integer> values) {
            addCriterion("zxs not in", values, "zxs");
            return (Criteria) this;
        }

        public Criteria andZxsBetween(Integer value1, Integer value2) {
            addCriterion("zxs between", value1, value2, "zxs");
            return (Criteria) this;
        }

        public Criteria andZxsNotBetween(Integer value1, Integer value2) {
            addCriterion("zxs not between", value1, value2, "zxs");
            return (Criteria) this;
        }

        public Criteria andMzxsIsNull() {
            addCriterion("mzxs is null");
            return (Criteria) this;
        }

        public Criteria andMzxsIsNotNull() {
            addCriterion("mzxs is not null");
            return (Criteria) this;
        }

        public Criteria andMzxsEqualTo(Integer value) {
            addCriterion("mzxs =", value, "mzxs");
            return (Criteria) this;
        }

        public Criteria andMzxsNotEqualTo(Integer value) {
            addCriterion("mzxs <>", value, "mzxs");
            return (Criteria) this;
        }

        public Criteria andMzxsGreaterThan(Integer value) {
            addCriterion("mzxs >", value, "mzxs");
            return (Criteria) this;
        }

        public Criteria andMzxsGreaterThanOrEqualTo(Integer value) {
            addCriterion("mzxs >=", value, "mzxs");
            return (Criteria) this;
        }

        public Criteria andMzxsLessThan(Integer value) {
            addCriterion("mzxs <", value, "mzxs");
            return (Criteria) this;
        }

        public Criteria andMzxsLessThanOrEqualTo(Integer value) {
            addCriterion("mzxs <=", value, "mzxs");
            return (Criteria) this;
        }

        public Criteria andMzxsIn(List<Integer> values) {
            addCriterion("mzxs in", values, "mzxs");
            return (Criteria) this;
        }

        public Criteria andMzxsNotIn(List<Integer> values) {
            addCriterion("mzxs not in", values, "mzxs");
            return (Criteria) this;
        }

        public Criteria andMzxsBetween(Integer value1, Integer value2) {
            addCriterion("mzxs between", value1, value2, "mzxs");
            return (Criteria) this;
        }

        public Criteria andMzxsNotBetween(Integer value1, Integer value2) {
            addCriterion("mzxs not between", value1, value2, "mzxs");
            return (Criteria) this;
        }

        public Criteria andSkxsIsNull() {
            addCriterion("skxs is null");
            return (Criteria) this;
        }

        public Criteria andSkxsIsNotNull() {
            addCriterion("skxs is not null");
            return (Criteria) this;
        }

        public Criteria andSkxsEqualTo(Integer value) {
            addCriterion("skxs =", value, "skxs");
            return (Criteria) this;
        }

        public Criteria andSkxsNotEqualTo(Integer value) {
            addCriterion("skxs <>", value, "skxs");
            return (Criteria) this;
        }

        public Criteria andSkxsGreaterThan(Integer value) {
            addCriterion("skxs >", value, "skxs");
            return (Criteria) this;
        }

        public Criteria andSkxsGreaterThanOrEqualTo(Integer value) {
            addCriterion("skxs >=", value, "skxs");
            return (Criteria) this;
        }

        public Criteria andSkxsLessThan(Integer value) {
            addCriterion("skxs <", value, "skxs");
            return (Criteria) this;
        }

        public Criteria andSkxsLessThanOrEqualTo(Integer value) {
            addCriterion("skxs <=", value, "skxs");
            return (Criteria) this;
        }

        public Criteria andSkxsIn(List<Integer> values) {
            addCriterion("skxs in", values, "skxs");
            return (Criteria) this;
        }

        public Criteria andSkxsNotIn(List<Integer> values) {
            addCriterion("skxs not in", values, "skxs");
            return (Criteria) this;
        }

        public Criteria andSkxsBetween(Integer value1, Integer value2) {
            addCriterion("skxs between", value1, value2, "skxs");
            return (Criteria) this;
        }

        public Criteria andSkxsNotBetween(Integer value1, Integer value2) {
            addCriterion("skxs not between", value1, value2, "skxs");
            return (Criteria) this;
        }

        public Criteria andSjxsIsNull() {
            addCriterion("sjxs is null");
            return (Criteria) this;
        }

        public Criteria andSjxsIsNotNull() {
            addCriterion("sjxs is not null");
            return (Criteria) this;
        }

        public Criteria andSjxsEqualTo(Integer value) {
            addCriterion("sjxs =", value, "sjxs");
            return (Criteria) this;
        }

        public Criteria andSjxsNotEqualTo(Integer value) {
            addCriterion("sjxs <>", value, "sjxs");
            return (Criteria) this;
        }

        public Criteria andSjxsGreaterThan(Integer value) {
            addCriterion("sjxs >", value, "sjxs");
            return (Criteria) this;
        }

        public Criteria andSjxsGreaterThanOrEqualTo(Integer value) {
            addCriterion("sjxs >=", value, "sjxs");
            return (Criteria) this;
        }

        public Criteria andSjxsLessThan(Integer value) {
            addCriterion("sjxs <", value, "sjxs");
            return (Criteria) this;
        }

        public Criteria andSjxsLessThanOrEqualTo(Integer value) {
            addCriterion("sjxs <=", value, "sjxs");
            return (Criteria) this;
        }

        public Criteria andSjxsIn(List<Integer> values) {
            addCriterion("sjxs in", values, "sjxs");
            return (Criteria) this;
        }

        public Criteria andSjxsNotIn(List<Integer> values) {
            addCriterion("sjxs not in", values, "sjxs");
            return (Criteria) this;
        }

        public Criteria andSjxsBetween(Integer value1, Integer value2) {
            addCriterion("sjxs between", value1, value2, "sjxs");
            return (Criteria) this;
        }

        public Criteria andSjxsNotBetween(Integer value1, Integer value2) {
            addCriterion("sjxs not between", value1, value2, "sjxs");
            return (Criteria) this;
        }

        public Criteria andSyxsIsNull() {
            addCriterion("syxs is null");
            return (Criteria) this;
        }

        public Criteria andSyxsIsNotNull() {
            addCriterion("syxs is not null");
            return (Criteria) this;
        }

        public Criteria andSyxsEqualTo(Integer value) {
            addCriterion("syxs =", value, "syxs");
            return (Criteria) this;
        }

        public Criteria andSyxsNotEqualTo(Integer value) {
            addCriterion("syxs <>", value, "syxs");
            return (Criteria) this;
        }

        public Criteria andSyxsGreaterThan(Integer value) {
            addCriterion("syxs >", value, "syxs");
            return (Criteria) this;
        }

        public Criteria andSyxsGreaterThanOrEqualTo(Integer value) {
            addCriterion("syxs >=", value, "syxs");
            return (Criteria) this;
        }

        public Criteria andSyxsLessThan(Integer value) {
            addCriterion("syxs <", value, "syxs");
            return (Criteria) this;
        }

        public Criteria andSyxsLessThanOrEqualTo(Integer value) {
            addCriterion("syxs <=", value, "syxs");
            return (Criteria) this;
        }

        public Criteria andSyxsIn(List<Integer> values) {
            addCriterion("syxs in", values, "syxs");
            return (Criteria) this;
        }

        public Criteria andSyxsNotIn(List<Integer> values) {
            addCriterion("syxs not in", values, "syxs");
            return (Criteria) this;
        }

        public Criteria andSyxsBetween(Integer value1, Integer value2) {
            addCriterion("syxs between", value1, value2, "syxs");
            return (Criteria) this;
        }

        public Criteria andSyxsNotBetween(Integer value1, Integer value2) {
            addCriterion("syxs not between", value1, value2, "syxs");
            return (Criteria) this;
        }

        public Criteria andXfIsNull() {
            addCriterion("xf is null");
            return (Criteria) this;
        }

        public Criteria andXfIsNotNull() {
            addCriterion("xf is not null");
            return (Criteria) this;
        }

        public Criteria andXfEqualTo(Float value) {
            addCriterion("xf =", value, "xf");
            return (Criteria) this;
        }

        public Criteria andXfNotEqualTo(Float value) {
            addCriterion("xf <>", value, "xf");
            return (Criteria) this;
        }

        public Criteria andXfGreaterThan(Float value) {
            addCriterion("xf >", value, "xf");
            return (Criteria) this;
        }

        public Criteria andXfGreaterThanOrEqualTo(Float value) {
            addCriterion("xf >=", value, "xf");
            return (Criteria) this;
        }

        public Criteria andXfLessThan(Float value) {
            addCriterion("xf <", value, "xf");
            return (Criteria) this;
        }

        public Criteria andXfLessThanOrEqualTo(Float value) {
            addCriterion("xf <=", value, "xf");
            return (Criteria) this;
        }

        public Criteria andXfIn(List<Float> values) {
            addCriterion("xf in", values, "xf");
            return (Criteria) this;
        }

        public Criteria andXfNotIn(List<Float> values) {
            addCriterion("xf not in", values, "xf");
            return (Criteria) this;
        }

        public Criteria andXfBetween(Float value1, Float value2) {
            addCriterion("xf between", value1, value2, "xf");
            return (Criteria) this;
        }

        public Criteria andXfNotBetween(Float value1, Float value2) {
            addCriterion("xf not between", value1, value2, "xf");
            return (Criteria) this;
        }

        public Criteria andKclxIsNull() {
            addCriterion("kclx is null");
            return (Criteria) this;
        }

        public Criteria andKclxIsNotNull() {
            addCriterion("kclx is not null");
            return (Criteria) this;
        }

        public Criteria andKclxEqualTo(String value) {
            addCriterion("kclx =", value, "kclx");
            return (Criteria) this;
        }

        public Criteria andKclxNotEqualTo(String value) {
            addCriterion("kclx <>", value, "kclx");
            return (Criteria) this;
        }

        public Criteria andKclxGreaterThan(String value) {
            addCriterion("kclx >", value, "kclx");
            return (Criteria) this;
        }

        public Criteria andKclxGreaterThanOrEqualTo(String value) {
            addCriterion("kclx >=", value, "kclx");
            return (Criteria) this;
        }

        public Criteria andKclxLessThan(String value) {
            addCriterion("kclx <", value, "kclx");
            return (Criteria) this;
        }

        public Criteria andKclxLessThanOrEqualTo(String value) {
            addCriterion("kclx <=", value, "kclx");
            return (Criteria) this;
        }

        public Criteria andKclxLike(String value) {
            addCriterion("kclx like", value, "kclx");
            return (Criteria) this;
        }

        public Criteria andKclxNotLike(String value) {
            addCriterion("kclx not like", value, "kclx");
            return (Criteria) this;
        }

        public Criteria andKclxIn(List<String> values) {
            addCriterion("kclx in", values, "kclx");
            return (Criteria) this;
        }

        public Criteria andKclxNotIn(List<String> values) {
            addCriterion("kclx not in", values, "kclx");
            return (Criteria) this;
        }

        public Criteria andKclxBetween(String value1, String value2) {
            addCriterion("kclx between", value1, value2, "kclx");
            return (Criteria) this;
        }

        public Criteria andKclxNotBetween(String value1, String value2) {
            addCriterion("kclx not between", value1, value2, "kclx");
            return (Criteria) this;
        }

        public Criteria andSfcxkIsNull() {
            addCriterion("sfcxk is null");
            return (Criteria) this;
        }

        public Criteria andSfcxkIsNotNull() {
            addCriterion("sfcxk is not null");
            return (Criteria) this;
        }

        public Criteria andSfcxkEqualTo(Integer value) {
            addCriterion("sfcxk =", value, "sfcxk");
            return (Criteria) this;
        }

        public Criteria andSfcxkNotEqualTo(Integer value) {
            addCriterion("sfcxk <>", value, "sfcxk");
            return (Criteria) this;
        }

        public Criteria andSfcxkGreaterThan(Integer value) {
            addCriterion("sfcxk >", value, "sfcxk");
            return (Criteria) this;
        }

        public Criteria andSfcxkGreaterThanOrEqualTo(Integer value) {
            addCriterion("sfcxk >=", value, "sfcxk");
            return (Criteria) this;
        }

        public Criteria andSfcxkLessThan(Integer value) {
            addCriterion("sfcxk <", value, "sfcxk");
            return (Criteria) this;
        }

        public Criteria andSfcxkLessThanOrEqualTo(Integer value) {
            addCriterion("sfcxk <=", value, "sfcxk");
            return (Criteria) this;
        }

        public Criteria andSfcxkIn(List<Integer> values) {
            addCriterion("sfcxk in", values, "sfcxk");
            return (Criteria) this;
        }

        public Criteria andSfcxkNotIn(List<Integer> values) {
            addCriterion("sfcxk not in", values, "sfcxk");
            return (Criteria) this;
        }

        public Criteria andSfcxkBetween(Integer value1, Integer value2) {
            addCriterion("sfcxk between", value1, value2, "sfcxk");
            return (Criteria) this;
        }

        public Criteria andSfcxkNotBetween(Integer value1, Integer value2) {
            addCriterion("sfcxk not between", value1, value2, "sfcxk");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("bz is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("bz is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("bz =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("bz <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("bz >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("bz >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("bz <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("bz <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("bz like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("bz not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("bz in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("bz not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("bz between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("bz not between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andKclx1IsNull() {
            addCriterion("kclx1 is null");
            return (Criteria) this;
        }

        public Criteria andKclx1IsNotNull() {
            addCriterion("kclx1 is not null");
            return (Criteria) this;
        }

        public Criteria andKclx1EqualTo(String value) {
            addCriterion("kclx1 =", value, "kclx1");
            return (Criteria) this;
        }

        public Criteria andKclx1NotEqualTo(String value) {
            addCriterion("kclx1 <>", value, "kclx1");
            return (Criteria) this;
        }

        public Criteria andKclx1GreaterThan(String value) {
            addCriterion("kclx1 >", value, "kclx1");
            return (Criteria) this;
        }

        public Criteria andKclx1GreaterThanOrEqualTo(String value) {
            addCriterion("kclx1 >=", value, "kclx1");
            return (Criteria) this;
        }

        public Criteria andKclx1LessThan(String value) {
            addCriterion("kclx1 <", value, "kclx1");
            return (Criteria) this;
        }

        public Criteria andKclx1LessThanOrEqualTo(String value) {
            addCriterion("kclx1 <=", value, "kclx1");
            return (Criteria) this;
        }

        public Criteria andKclx1Like(String value) {
            addCriterion("kclx1 like", value, "kclx1");
            return (Criteria) this;
        }

        public Criteria andKclx1NotLike(String value) {
            addCriterion("kclx1 not like", value, "kclx1");
            return (Criteria) this;
        }

        public Criteria andKclx1In(List<String> values) {
            addCriterion("kclx1 in", values, "kclx1");
            return (Criteria) this;
        }

        public Criteria andKclx1NotIn(List<String> values) {
            addCriterion("kclx1 not in", values, "kclx1");
            return (Criteria) this;
        }

        public Criteria andKclx1Between(String value1, String value2) {
            addCriterion("kclx1 between", value1, value2, "kclx1");
            return (Criteria) this;
        }

        public Criteria andKclx1NotBetween(String value1, String value2) {
            addCriterion("kclx1 not between", value1, value2, "kclx1");
            return (Criteria) this;
        }

        public Criteria andKclx2IsNull() {
            addCriterion("kclx2 is null");
            return (Criteria) this;
        }

        public Criteria andKclx2IsNotNull() {
            addCriterion("kclx2 is not null");
            return (Criteria) this;
        }

        public Criteria andKclx2EqualTo(String value) {
            addCriterion("kclx2 =", value, "kclx2");
            return (Criteria) this;
        }

        public Criteria andKclx2NotEqualTo(String value) {
            addCriterion("kclx2 <>", value, "kclx2");
            return (Criteria) this;
        }

        public Criteria andKclx2GreaterThan(String value) {
            addCriterion("kclx2 >", value, "kclx2");
            return (Criteria) this;
        }

        public Criteria andKclx2GreaterThanOrEqualTo(String value) {
            addCriterion("kclx2 >=", value, "kclx2");
            return (Criteria) this;
        }

        public Criteria andKclx2LessThan(String value) {
            addCriterion("kclx2 <", value, "kclx2");
            return (Criteria) this;
        }

        public Criteria andKclx2LessThanOrEqualTo(String value) {
            addCriterion("kclx2 <=", value, "kclx2");
            return (Criteria) this;
        }

        public Criteria andKclx2Like(String value) {
            addCriterion("kclx2 like", value, "kclx2");
            return (Criteria) this;
        }

        public Criteria andKclx2NotLike(String value) {
            addCriterion("kclx2 not like", value, "kclx2");
            return (Criteria) this;
        }

        public Criteria andKclx2In(List<String> values) {
            addCriterion("kclx2 in", values, "kclx2");
            return (Criteria) this;
        }

        public Criteria andKclx2NotIn(List<String> values) {
            addCriterion("kclx2 not in", values, "kclx2");
            return (Criteria) this;
        }

        public Criteria andKclx2Between(String value1, String value2) {
            addCriterion("kclx2 between", value1, value2, "kclx2");
            return (Criteria) this;
        }

        public Criteria andKclx2NotBetween(String value1, String value2) {
            addCriterion("kclx2 not between", value1, value2, "kclx2");
            return (Criteria) this;
        }

        public Criteria andKclx3IsNull() {
            addCriterion("kclx3 is null");
            return (Criteria) this;
        }

        public Criteria andKclx3IsNotNull() {
            addCriterion("kclx3 is not null");
            return (Criteria) this;
        }

        public Criteria andKclx3EqualTo(String value) {
            addCriterion("kclx3 =", value, "kclx3");
            return (Criteria) this;
        }

        public Criteria andKclx3NotEqualTo(String value) {
            addCriterion("kclx3 <>", value, "kclx3");
            return (Criteria) this;
        }

        public Criteria andKclx3GreaterThan(String value) {
            addCriterion("kclx3 >", value, "kclx3");
            return (Criteria) this;
        }

        public Criteria andKclx3GreaterThanOrEqualTo(String value) {
            addCriterion("kclx3 >=", value, "kclx3");
            return (Criteria) this;
        }

        public Criteria andKclx3LessThan(String value) {
            addCriterion("kclx3 <", value, "kclx3");
            return (Criteria) this;
        }

        public Criteria andKclx3LessThanOrEqualTo(String value) {
            addCriterion("kclx3 <=", value, "kclx3");
            return (Criteria) this;
        }

        public Criteria andKclx3Like(String value) {
            addCriterion("kclx3 like", value, "kclx3");
            return (Criteria) this;
        }

        public Criteria andKclx3NotLike(String value) {
            addCriterion("kclx3 not like", value, "kclx3");
            return (Criteria) this;
        }

        public Criteria andKclx3In(List<String> values) {
            addCriterion("kclx3 in", values, "kclx3");
            return (Criteria) this;
        }

        public Criteria andKclx3NotIn(List<String> values) {
            addCriterion("kclx3 not in", values, "kclx3");
            return (Criteria) this;
        }

        public Criteria andKclx3Between(String value1, String value2) {
            addCriterion("kclx3 between", value1, value2, "kclx3");
            return (Criteria) this;
        }

        public Criteria andKclx3NotBetween(String value1, String value2) {
            addCriterion("kclx3 not between", value1, value2, "kclx3");
            return (Criteria) this;
        }

        public Criteria andKcxsIsNull() {
            addCriterion("kcxs is null");
            return (Criteria) this;
        }

        public Criteria andKcxsIsNotNull() {
            addCriterion("kcxs is not null");
            return (Criteria) this;
        }

        public Criteria andKcxsEqualTo(Float value) {
            addCriterion("kcxs =", value, "kcxs");
            return (Criteria) this;
        }

        public Criteria andKcxsNotEqualTo(Float value) {
            addCriterion("kcxs <>", value, "kcxs");
            return (Criteria) this;
        }

        public Criteria andKcxsGreaterThan(Float value) {
            addCriterion("kcxs >", value, "kcxs");
            return (Criteria) this;
        }

        public Criteria andKcxsGreaterThanOrEqualTo(Float value) {
            addCriterion("kcxs >=", value, "kcxs");
            return (Criteria) this;
        }

        public Criteria andKcxsLessThan(Float value) {
            addCriterion("kcxs <", value, "kcxs");
            return (Criteria) this;
        }

        public Criteria andKcxsLessThanOrEqualTo(Float value) {
            addCriterion("kcxs <=", value, "kcxs");
            return (Criteria) this;
        }

        public Criteria andKcxsIn(List<Float> values) {
            addCriterion("kcxs in", values, "kcxs");
            return (Criteria) this;
        }

        public Criteria andKcxsNotIn(List<Float> values) {
            addCriterion("kcxs not in", values, "kcxs");
            return (Criteria) this;
        }

        public Criteria andKcxsBetween(Float value1, Float value2) {
            addCriterion("kcxs between", value1, value2, "kcxs");
            return (Criteria) this;
        }

        public Criteria andKcxsNotBetween(Float value1, Float value2) {
            addCriterion("kcxs not between", value1, value2, "kcxs");
            return (Criteria) this;
        }

        public Criteria andRsxsIsNull() {
            addCriterion("rsxs is null");
            return (Criteria) this;
        }

        public Criteria andRsxsIsNotNull() {
            addCriterion("rsxs is not null");
            return (Criteria) this;
        }

        public Criteria andRsxsEqualTo(Float value) {
            addCriterion("rsxs =", value, "rsxs");
            return (Criteria) this;
        }

        public Criteria andRsxsNotEqualTo(Float value) {
            addCriterion("rsxs <>", value, "rsxs");
            return (Criteria) this;
        }

        public Criteria andRsxsGreaterThan(Float value) {
            addCriterion("rsxs >", value, "rsxs");
            return (Criteria) this;
        }

        public Criteria andRsxsGreaterThanOrEqualTo(Float value) {
            addCriterion("rsxs >=", value, "rsxs");
            return (Criteria) this;
        }

        public Criteria andRsxsLessThan(Float value) {
            addCriterion("rsxs <", value, "rsxs");
            return (Criteria) this;
        }

        public Criteria andRsxsLessThanOrEqualTo(Float value) {
            addCriterion("rsxs <=", value, "rsxs");
            return (Criteria) this;
        }

        public Criteria andRsxsIn(List<Float> values) {
            addCriterion("rsxs in", values, "rsxs");
            return (Criteria) this;
        }

        public Criteria andRsxsNotIn(List<Float> values) {
            addCriterion("rsxs not in", values, "rsxs");
            return (Criteria) this;
        }

        public Criteria andRsxsBetween(Float value1, Float value2) {
            addCriterion("rsxs between", value1, value2, "rsxs");
            return (Criteria) this;
        }

        public Criteria andRsxsNotBetween(Float value1, Float value2) {
            addCriterion("rsxs not between", value1, value2, "rsxs");
            return (Criteria) this;
        }

        public Criteria andLljxgzlIsNull() {
            addCriterion("lljxgzl is null");
            return (Criteria) this;
        }

        public Criteria andLljxgzlIsNotNull() {
            addCriterion("lljxgzl is not null");
            return (Criteria) this;
        }

        public Criteria andLljxgzlEqualTo(Float value) {
            addCriterion("lljxgzl =", value, "lljxgzl");
            return (Criteria) this;
        }

        public Criteria andLljxgzlNotEqualTo(Float value) {
            addCriterion("lljxgzl <>", value, "lljxgzl");
            return (Criteria) this;
        }

        public Criteria andLljxgzlGreaterThan(Float value) {
            addCriterion("lljxgzl >", value, "lljxgzl");
            return (Criteria) this;
        }

        public Criteria andLljxgzlGreaterThanOrEqualTo(Float value) {
            addCriterion("lljxgzl >=", value, "lljxgzl");
            return (Criteria) this;
        }

        public Criteria andLljxgzlLessThan(Float value) {
            addCriterion("lljxgzl <", value, "lljxgzl");
            return (Criteria) this;
        }

        public Criteria andLljxgzlLessThanOrEqualTo(Float value) {
            addCriterion("lljxgzl <=", value, "lljxgzl");
            return (Criteria) this;
        }

        public Criteria andLljxgzlIn(List<Float> values) {
            addCriterion("lljxgzl in", values, "lljxgzl");
            return (Criteria) this;
        }

        public Criteria andLljxgzlNotIn(List<Float> values) {
            addCriterion("lljxgzl not in", values, "lljxgzl");
            return (Criteria) this;
        }

        public Criteria andLljxgzlBetween(Float value1, Float value2) {
            addCriterion("lljxgzl between", value1, value2, "lljxgzl");
            return (Criteria) this;
        }

        public Criteria andLljxgzlNotBetween(Float value1, Float value2) {
            addCriterion("lljxgzl not between", value1, value2, "lljxgzl");
            return (Criteria) this;
        }

        public Criteria andSjjxgzlIsNull() {
            addCriterion("sjjxgzl is null");
            return (Criteria) this;
        }

        public Criteria andSjjxgzlIsNotNull() {
            addCriterion("sjjxgzl is not null");
            return (Criteria) this;
        }

        public Criteria andSjjxgzlEqualTo(Float value) {
            addCriterion("sjjxgzl =", value, "sjjxgzl");
            return (Criteria) this;
        }

        public Criteria andSjjxgzlNotEqualTo(Float value) {
            addCriterion("sjjxgzl <>", value, "sjjxgzl");
            return (Criteria) this;
        }

        public Criteria andSjjxgzlGreaterThan(Float value) {
            addCriterion("sjjxgzl >", value, "sjjxgzl");
            return (Criteria) this;
        }

        public Criteria andSjjxgzlGreaterThanOrEqualTo(Float value) {
            addCriterion("sjjxgzl >=", value, "sjjxgzl");
            return (Criteria) this;
        }

        public Criteria andSjjxgzlLessThan(Float value) {
            addCriterion("sjjxgzl <", value, "sjjxgzl");
            return (Criteria) this;
        }

        public Criteria andSjjxgzlLessThanOrEqualTo(Float value) {
            addCriterion("sjjxgzl <=", value, "sjjxgzl");
            return (Criteria) this;
        }

        public Criteria andSjjxgzlIn(List<Float> values) {
            addCriterion("sjjxgzl in", values, "sjjxgzl");
            return (Criteria) this;
        }

        public Criteria andSjjxgzlNotIn(List<Float> values) {
            addCriterion("sjjxgzl not in", values, "sjjxgzl");
            return (Criteria) this;
        }

        public Criteria andSjjxgzlBetween(Float value1, Float value2) {
            addCriterion("sjjxgzl between", value1, value2, "sjjxgzl");
            return (Criteria) this;
        }

        public Criteria andSjjxgzlNotBetween(Float value1, Float value2) {
            addCriterion("sjjxgzl not between", value1, value2, "sjjxgzl");
            return (Criteria) this;
        }

        public Criteria andSumgzlIsNull() {
            addCriterion("sumgzl is null");
            return (Criteria) this;
        }

        public Criteria andSumgzlIsNotNull() {
            addCriterion("sumgzl is not null");
            return (Criteria) this;
        }

        public Criteria andSumgzlEqualTo(Float value) {
            addCriterion("sumgzl =", value, "sumgzl");
            return (Criteria) this;
        }

        public Criteria andSumgzlNotEqualTo(Float value) {
            addCriterion("sumgzl <>", value, "sumgzl");
            return (Criteria) this;
        }

        public Criteria andSumgzlGreaterThan(Float value) {
            addCriterion("sumgzl >", value, "sumgzl");
            return (Criteria) this;
        }

        public Criteria andSumgzlGreaterThanOrEqualTo(Float value) {
            addCriterion("sumgzl >=", value, "sumgzl");
            return (Criteria) this;
        }

        public Criteria andSumgzlLessThan(Float value) {
            addCriterion("sumgzl <", value, "sumgzl");
            return (Criteria) this;
        }

        public Criteria andSumgzlLessThanOrEqualTo(Float value) {
            addCriterion("sumgzl <=", value, "sumgzl");
            return (Criteria) this;
        }

        public Criteria andSumgzlIn(List<Float> values) {
            addCriterion("sumgzl in", values, "sumgzl");
            return (Criteria) this;
        }

        public Criteria andSumgzlNotIn(List<Float> values) {
            addCriterion("sumgzl not in", values, "sumgzl");
            return (Criteria) this;
        }

        public Criteria andSumgzlBetween(Float value1, Float value2) {
            addCriterion("sumgzl between", value1, value2, "sumgzl");
            return (Criteria) this;
        }

        public Criteria andSumgzlNotBetween(Float value1, Float value2) {
            addCriterion("sumgzl not between", value1, value2, "sumgzl");
            return (Criteria) this;
        }

        public Criteria andCwdIsNull() {
            addCriterion("cwd is null");
            return (Criteria) this;
        }

        public Criteria andCwdIsNotNull() {
            addCriterion("cwd is not null");
            return (Criteria) this;
        }

        public Criteria andCwdEqualTo(String value) {
            addCriterion("cwd =", value, "cwd");
            return (Criteria) this;
        }

        public Criteria andCwdNotEqualTo(String value) {
            addCriterion("cwd <>", value, "cwd");
            return (Criteria) this;
        }

        public Criteria andCwdGreaterThan(String value) {
            addCriterion("cwd >", value, "cwd");
            return (Criteria) this;
        }

        public Criteria andCwdGreaterThanOrEqualTo(String value) {
            addCriterion("cwd >=", value, "cwd");
            return (Criteria) this;
        }

        public Criteria andCwdLessThan(String value) {
            addCriterion("cwd <", value, "cwd");
            return (Criteria) this;
        }

        public Criteria andCwdLessThanOrEqualTo(String value) {
            addCriterion("cwd <=", value, "cwd");
            return (Criteria) this;
        }

        public Criteria andCwdLike(String value) {
            addCriterion("cwd like", value, "cwd");
            return (Criteria) this;
        }

        public Criteria andCwdNotLike(String value) {
            addCriterion("cwd not like", value, "cwd");
            return (Criteria) this;
        }

        public Criteria andCwdIn(List<String> values) {
            addCriterion("cwd in", values, "cwd");
            return (Criteria) this;
        }

        public Criteria andCwdNotIn(List<String> values) {
            addCriterion("cwd not in", values, "cwd");
            return (Criteria) this;
        }

        public Criteria andCwdBetween(String value1, String value2) {
            addCriterion("cwd between", value1, value2, "cwd");
            return (Criteria) this;
        }

        public Criteria andCwdNotBetween(String value1, String value2) {
            addCriterion("cwd not between", value1, value2, "cwd");
            return (Criteria) this;
        }

        public Criteria andJyIsNull() {
            addCriterion("jy is null");
            return (Criteria) this;
        }

        public Criteria andJyIsNotNull() {
            addCriterion("jy is not null");
            return (Criteria) this;
        }

        public Criteria andJyEqualTo(String value) {
            addCriterion("jy =", value, "jy");
            return (Criteria) this;
        }

        public Criteria andJyNotEqualTo(String value) {
            addCriterion("jy <>", value, "jy");
            return (Criteria) this;
        }

        public Criteria andJyGreaterThan(String value) {
            addCriterion("jy >", value, "jy");
            return (Criteria) this;
        }

        public Criteria andJyGreaterThanOrEqualTo(String value) {
            addCriterion("jy >=", value, "jy");
            return (Criteria) this;
        }

        public Criteria andJyLessThan(String value) {
            addCriterion("jy <", value, "jy");
            return (Criteria) this;
        }

        public Criteria andJyLessThanOrEqualTo(String value) {
            addCriterion("jy <=", value, "jy");
            return (Criteria) this;
        }

        public Criteria andJyLike(String value) {
            addCriterion("jy like", value, "jy");
            return (Criteria) this;
        }

        public Criteria andJyNotLike(String value) {
            addCriterion("jy not like", value, "jy");
            return (Criteria) this;
        }

        public Criteria andJyIn(List<String> values) {
            addCriterion("jy in", values, "jy");
            return (Criteria) this;
        }

        public Criteria andJyNotIn(List<String> values) {
            addCriterion("jy not in", values, "jy");
            return (Criteria) this;
        }

        public Criteria andJyBetween(String value1, String value2) {
            addCriterion("jy between", value1, value2, "jy");
            return (Criteria) this;
        }

        public Criteria andJyNotBetween(String value1, String value2) {
            addCriterion("jy not between", value1, value2, "jy");
            return (Criteria) this;
        }
    }

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