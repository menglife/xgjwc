package com.xzit.ssm.entity;

import java.util.ArrayList;
import java.util.List;

public class SyworkloadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SyworkloadExample() {
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

        public Criteria andSyidIsNull() {
            addCriterion("syid is null");
            return (Criteria) this;
        }

        public Criteria andSyidIsNotNull() {
            addCriterion("syid is not null");
            return (Criteria) this;
        }

        public Criteria andSyidEqualTo(Integer value) {
            addCriterion("syid =", value, "syid");
            return (Criteria) this;
        }

        public Criteria andSyidNotEqualTo(Integer value) {
            addCriterion("syid <>", value, "syid");
            return (Criteria) this;
        }

        public Criteria andSyidGreaterThan(Integer value) {
            addCriterion("syid >", value, "syid");
            return (Criteria) this;
        }

        public Criteria andSyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("syid >=", value, "syid");
            return (Criteria) this;
        }

        public Criteria andSyidLessThan(Integer value) {
            addCriterion("syid <", value, "syid");
            return (Criteria) this;
        }

        public Criteria andSyidLessThanOrEqualTo(Integer value) {
            addCriterion("syid <=", value, "syid");
            return (Criteria) this;
        }

        public Criteria andSyidIn(List<Integer> values) {
            addCriterion("syid in", values, "syid");
            return (Criteria) this;
        }

        public Criteria andSyidNotIn(List<Integer> values) {
            addCriterion("syid not in", values, "syid");
            return (Criteria) this;
        }

        public Criteria andSyidBetween(Integer value1, Integer value2) {
            addCriterion("syid between", value1, value2, "syid");
            return (Criteria) this;
        }

        public Criteria andSyidNotBetween(Integer value1, Integer value2) {
            addCriterion("syid not between", value1, value2, "syid");
            return (Criteria) this;
        }

        public Criteria andXyidIsNull() {
            addCriterion("xyid is null");
            return (Criteria) this;
        }

        public Criteria andXyidIsNotNull() {
            addCriterion("xyid is not null");
            return (Criteria) this;
        }

        public Criteria andXyidEqualTo(Integer value) {
            addCriterion("xyid =", value, "xyid");
            return (Criteria) this;
        }

        public Criteria andXyidNotEqualTo(Integer value) {
            addCriterion("xyid <>", value, "xyid");
            return (Criteria) this;
        }

        public Criteria andXyidGreaterThan(Integer value) {
            addCriterion("xyid >", value, "xyid");
            return (Criteria) this;
        }

        public Criteria andXyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("xyid >=", value, "xyid");
            return (Criteria) this;
        }

        public Criteria andXyidLessThan(Integer value) {
            addCriterion("xyid <", value, "xyid");
            return (Criteria) this;
        }

        public Criteria andXyidLessThanOrEqualTo(Integer value) {
            addCriterion("xyid <=", value, "xyid");
            return (Criteria) this;
        }

        public Criteria andXyidIn(List<Integer> values) {
            addCriterion("xyid in", values, "xyid");
            return (Criteria) this;
        }

        public Criteria andXyidNotIn(List<Integer> values) {
            addCriterion("xyid not in", values, "xyid");
            return (Criteria) this;
        }

        public Criteria andXyidBetween(Integer value1, Integer value2) {
            addCriterion("xyid between", value1, value2, "xyid");
            return (Criteria) this;
        }

        public Criteria andXyidNotBetween(Integer value1, Integer value2) {
            addCriterion("xyid not between", value1, value2, "xyid");
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

        public Criteria andSyzxsIsNull() {
            addCriterion("syzxs is null");
            return (Criteria) this;
        }

        public Criteria andSyzxsIsNotNull() {
            addCriterion("syzxs is not null");
            return (Criteria) this;
        }

        public Criteria andSyzxsEqualTo(Integer value) {
            addCriterion("syzxs =", value, "syzxs");
            return (Criteria) this;
        }

        public Criteria andSyzxsNotEqualTo(Integer value) {
            addCriterion("syzxs <>", value, "syzxs");
            return (Criteria) this;
        }

        public Criteria andSyzxsGreaterThan(Integer value) {
            addCriterion("syzxs >", value, "syzxs");
            return (Criteria) this;
        }

        public Criteria andSyzxsGreaterThanOrEqualTo(Integer value) {
            addCriterion("syzxs >=", value, "syzxs");
            return (Criteria) this;
        }

        public Criteria andSyzxsLessThan(Integer value) {
            addCriterion("syzxs <", value, "syzxs");
            return (Criteria) this;
        }

        public Criteria andSyzxsLessThanOrEqualTo(Integer value) {
            addCriterion("syzxs <=", value, "syzxs");
            return (Criteria) this;
        }

        public Criteria andSyzxsIn(List<Integer> values) {
            addCriterion("syzxs in", values, "syzxs");
            return (Criteria) this;
        }

        public Criteria andSyzxsNotIn(List<Integer> values) {
            addCriterion("syzxs not in", values, "syzxs");
            return (Criteria) this;
        }

        public Criteria andSyzxsBetween(Integer value1, Integer value2) {
            addCriterion("syzxs between", value1, value2, "syzxs");
            return (Criteria) this;
        }

        public Criteria andSyzxsNotBetween(Integer value1, Integer value2) {
            addCriterion("syzxs not between", value1, value2, "syzxs");
            return (Criteria) this;
        }

        public Criteria andFpcxIsNull() {
            addCriterion("fpcx is null");
            return (Criteria) this;
        }

        public Criteria andFpcxIsNotNull() {
            addCriterion("fpcx is not null");
            return (Criteria) this;
        }

        public Criteria andFpcxEqualTo(Integer value) {
            addCriterion("fpcx =", value, "fpcx");
            return (Criteria) this;
        }

        public Criteria andFpcxNotEqualTo(Integer value) {
            addCriterion("fpcx <>", value, "fpcx");
            return (Criteria) this;
        }

        public Criteria andFpcxGreaterThan(Integer value) {
            addCriterion("fpcx >", value, "fpcx");
            return (Criteria) this;
        }

        public Criteria andFpcxGreaterThanOrEqualTo(Integer value) {
            addCriterion("fpcx >=", value, "fpcx");
            return (Criteria) this;
        }

        public Criteria andFpcxLessThan(Integer value) {
            addCriterion("fpcx <", value, "fpcx");
            return (Criteria) this;
        }

        public Criteria andFpcxLessThanOrEqualTo(Integer value) {
            addCriterion("fpcx <=", value, "fpcx");
            return (Criteria) this;
        }

        public Criteria andFpcxIn(List<Integer> values) {
            addCriterion("fpcx in", values, "fpcx");
            return (Criteria) this;
        }

        public Criteria andFpcxNotIn(List<Integer> values) {
            addCriterion("fpcx not in", values, "fpcx");
            return (Criteria) this;
        }

        public Criteria andFpcxBetween(Integer value1, Integer value2) {
            addCriterion("fpcx between", value1, value2, "fpcx");
            return (Criteria) this;
        }

        public Criteria andFpcxNotBetween(Integer value1, Integer value2) {
            addCriterion("fpcx not between", value1, value2, "fpcx");
            return (Criteria) this;
        }

        public Criteria andFpxsIsNull() {
            addCriterion("fpxs is null");
            return (Criteria) this;
        }

        public Criteria andFpxsIsNotNull() {
            addCriterion("fpxs is not null");
            return (Criteria) this;
        }

        public Criteria andFpxsEqualTo(Integer value) {
            addCriterion("fpxs =", value, "fpxs");
            return (Criteria) this;
        }

        public Criteria andFpxsNotEqualTo(Integer value) {
            addCriterion("fpxs <>", value, "fpxs");
            return (Criteria) this;
        }

        public Criteria andFpxsGreaterThan(Integer value) {
            addCriterion("fpxs >", value, "fpxs");
            return (Criteria) this;
        }

        public Criteria andFpxsGreaterThanOrEqualTo(Integer value) {
            addCriterion("fpxs >=", value, "fpxs");
            return (Criteria) this;
        }

        public Criteria andFpxsLessThan(Integer value) {
            addCriterion("fpxs <", value, "fpxs");
            return (Criteria) this;
        }

        public Criteria andFpxsLessThanOrEqualTo(Integer value) {
            addCriterion("fpxs <=", value, "fpxs");
            return (Criteria) this;
        }

        public Criteria andFpxsIn(List<Integer> values) {
            addCriterion("fpxs in", values, "fpxs");
            return (Criteria) this;
        }

        public Criteria andFpxsNotIn(List<Integer> values) {
            addCriterion("fpxs not in", values, "fpxs");
            return (Criteria) this;
        }

        public Criteria andFpxsBetween(Integer value1, Integer value2) {
            addCriterion("fpxs between", value1, value2, "fpxs");
            return (Criteria) this;
        }

        public Criteria andFpxsNotBetween(Integer value1, Integer value2) {
            addCriterion("fpxs not between", value1, value2, "fpxs");
            return (Criteria) this;
        }

        public Criteria andFpgzlIsNull() {
            addCriterion("fpgzl is null");
            return (Criteria) this;
        }

        public Criteria andFpgzlIsNotNull() {
            addCriterion("fpgzl is not null");
            return (Criteria) this;
        }

        public Criteria andFpgzlEqualTo(Float value) {
            addCriterion("fpgzl =", value, "fpgzl");
            return (Criteria) this;
        }

        public Criteria andFpgzlNotEqualTo(Float value) {
            addCriterion("fpgzl <>", value, "fpgzl");
            return (Criteria) this;
        }

        public Criteria andFpgzlGreaterThan(Float value) {
            addCriterion("fpgzl >", value, "fpgzl");
            return (Criteria) this;
        }

        public Criteria andFpgzlGreaterThanOrEqualTo(Float value) {
            addCriterion("fpgzl >=", value, "fpgzl");
            return (Criteria) this;
        }

        public Criteria andFpgzlLessThan(Float value) {
            addCriterion("fpgzl <", value, "fpgzl");
            return (Criteria) this;
        }

        public Criteria andFpgzlLessThanOrEqualTo(Float value) {
            addCriterion("fpgzl <=", value, "fpgzl");
            return (Criteria) this;
        }

        public Criteria andFpgzlIn(List<Float> values) {
            addCriterion("fpgzl in", values, "fpgzl");
            return (Criteria) this;
        }

        public Criteria andFpgzlNotIn(List<Float> values) {
            addCriterion("fpgzl not in", values, "fpgzl");
            return (Criteria) this;
        }

        public Criteria andFpgzlBetween(Float value1, Float value2) {
            addCriterion("fpgzl between", value1, value2, "fpgzl");
            return (Criteria) this;
        }

        public Criteria andFpgzlNotBetween(Float value1, Float value2) {
            addCriterion("fpgzl not between", value1, value2, "fpgzl");
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