package com.xzit.ssm.entity;

import java.util.ArrayList;
import java.util.List;

public class TraintypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TraintypeExample() {
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

        public Criteria andPtidIsNull() {
            addCriterion("ptid is null");
            return (Criteria) this;
        }

        public Criteria andPtidIsNotNull() {
            addCriterion("ptid is not null");
            return (Criteria) this;
        }

        public Criteria andPtidEqualTo(Integer value) {
            addCriterion("ptid =", value, "ptid");
            return (Criteria) this;
        }

        public Criteria andPtidNotEqualTo(Integer value) {
            addCriterion("ptid <>", value, "ptid");
            return (Criteria) this;
        }

        public Criteria andPtidGreaterThan(Integer value) {
            addCriterion("ptid >", value, "ptid");
            return (Criteria) this;
        }

        public Criteria andPtidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ptid >=", value, "ptid");
            return (Criteria) this;
        }

        public Criteria andPtidLessThan(Integer value) {
            addCriterion("ptid <", value, "ptid");
            return (Criteria) this;
        }

        public Criteria andPtidLessThanOrEqualTo(Integer value) {
            addCriterion("ptid <=", value, "ptid");
            return (Criteria) this;
        }

        public Criteria andPtidIn(List<Integer> values) {
            addCriterion("ptid in", values, "ptid");
            return (Criteria) this;
        }

        public Criteria andPtidNotIn(List<Integer> values) {
            addCriterion("ptid not in", values, "ptid");
            return (Criteria) this;
        }

        public Criteria andPtidBetween(Integer value1, Integer value2) {
            addCriterion("ptid between", value1, value2, "ptid");
            return (Criteria) this;
        }

        public Criteria andPtidNotBetween(Integer value1, Integer value2) {
            addCriterion("ptid not between", value1, value2, "ptid");
            return (Criteria) this;
        }

        public Criteria andPtnameIsNull() {
            addCriterion("ptname is null");
            return (Criteria) this;
        }

        public Criteria andPtnameIsNotNull() {
            addCriterion("ptname is not null");
            return (Criteria) this;
        }

        public Criteria andPtnameEqualTo(String value) {
            addCriterion("ptname =", value, "ptname");
            return (Criteria) this;
        }

        public Criteria andPtnameNotEqualTo(String value) {
            addCriterion("ptname <>", value, "ptname");
            return (Criteria) this;
        }

        public Criteria andPtnameGreaterThan(String value) {
            addCriterion("ptname >", value, "ptname");
            return (Criteria) this;
        }

        public Criteria andPtnameGreaterThanOrEqualTo(String value) {
            addCriterion("ptname >=", value, "ptname");
            return (Criteria) this;
        }

        public Criteria andPtnameLessThan(String value) {
            addCriterion("ptname <", value, "ptname");
            return (Criteria) this;
        }

        public Criteria andPtnameLessThanOrEqualTo(String value) {
            addCriterion("ptname <=", value, "ptname");
            return (Criteria) this;
        }

        public Criteria andPtnameLike(String value) {
            addCriterion("ptname like", value, "ptname");
            return (Criteria) this;
        }

        public Criteria andPtnameNotLike(String value) {
            addCriterion("ptname not like", value, "ptname");
            return (Criteria) this;
        }

        public Criteria andPtnameIn(List<String> values) {
            addCriterion("ptname in", values, "ptname");
            return (Criteria) this;
        }

        public Criteria andPtnameNotIn(List<String> values) {
            addCriterion("ptname not in", values, "ptname");
            return (Criteria) this;
        }

        public Criteria andPtnameBetween(String value1, String value2) {
            addCriterion("ptname between", value1, value2, "ptname");
            return (Criteria) this;
        }

        public Criteria andPtnameNotBetween(String value1, String value2) {
            addCriterion("ptname not between", value1, value2, "ptname");
            return (Criteria) this;
        }

        public Criteria andNvalueIsNull() {
            addCriterion("nvalue is null");
            return (Criteria) this;
        }

        public Criteria andNvalueIsNotNull() {
            addCriterion("nvalue is not null");
            return (Criteria) this;
        }

        public Criteria andNvalueEqualTo(Integer value) {
            addCriterion("nvalue =", value, "nvalue");
            return (Criteria) this;
        }

        public Criteria andNvalueNotEqualTo(Integer value) {
            addCriterion("nvalue <>", value, "nvalue");
            return (Criteria) this;
        }

        public Criteria andNvalueGreaterThan(Integer value) {
            addCriterion("nvalue >", value, "nvalue");
            return (Criteria) this;
        }

        public Criteria andNvalueGreaterThanOrEqualTo(Integer value) {
            addCriterion("nvalue >=", value, "nvalue");
            return (Criteria) this;
        }

        public Criteria andNvalueLessThan(Integer value) {
            addCriterion("nvalue <", value, "nvalue");
            return (Criteria) this;
        }

        public Criteria andNvalueLessThanOrEqualTo(Integer value) {
            addCriterion("nvalue <=", value, "nvalue");
            return (Criteria) this;
        }

        public Criteria andNvalueIn(List<Integer> values) {
            addCriterion("nvalue in", values, "nvalue");
            return (Criteria) this;
        }

        public Criteria andNvalueNotIn(List<Integer> values) {
            addCriterion("nvalue not in", values, "nvalue");
            return (Criteria) this;
        }

        public Criteria andNvalueBetween(Integer value1, Integer value2) {
            addCriterion("nvalue between", value1, value2, "nvalue");
            return (Criteria) this;
        }

        public Criteria andNvalueNotBetween(Integer value1, Integer value2) {
            addCriterion("nvalue not between", value1, value2, "nvalue");
            return (Criteria) this;
        }

        public Criteria andKvalueIsNull() {
            addCriterion("kvalue is null");
            return (Criteria) this;
        }

        public Criteria andKvalueIsNotNull() {
            addCriterion("kvalue is not null");
            return (Criteria) this;
        }

        public Criteria andKvalueEqualTo(Float value) {
            addCriterion("kvalue =", value, "kvalue");
            return (Criteria) this;
        }

        public Criteria andKvalueNotEqualTo(Float value) {
            addCriterion("kvalue <>", value, "kvalue");
            return (Criteria) this;
        }

        public Criteria andKvalueGreaterThan(Float value) {
            addCriterion("kvalue >", value, "kvalue");
            return (Criteria) this;
        }

        public Criteria andKvalueGreaterThanOrEqualTo(Float value) {
            addCriterion("kvalue >=", value, "kvalue");
            return (Criteria) this;
        }

        public Criteria andKvalueLessThan(Float value) {
            addCriterion("kvalue <", value, "kvalue");
            return (Criteria) this;
        }

        public Criteria andKvalueLessThanOrEqualTo(Float value) {
            addCriterion("kvalue <=", value, "kvalue");
            return (Criteria) this;
        }

        public Criteria andKvalueIn(List<Float> values) {
            addCriterion("kvalue in", values, "kvalue");
            return (Criteria) this;
        }

        public Criteria andKvalueNotIn(List<Float> values) {
            addCriterion("kvalue not in", values, "kvalue");
            return (Criteria) this;
        }

        public Criteria andKvalueBetween(Float value1, Float value2) {
            addCriterion("kvalue between", value1, value2, "kvalue");
            return (Criteria) this;
        }

        public Criteria andKvalueNotBetween(Float value1, Float value2) {
            addCriterion("kvalue not between", value1, value2, "kvalue");
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