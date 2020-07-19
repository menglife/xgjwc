package com.xzit.ssm.entity;

import java.util.ArrayList;
import java.util.List;

public class TotalworkloadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TotalworkloadExample() {
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

        public Criteria andGzlidIsNull() {
            addCriterion("gzlid is null");
            return (Criteria) this;
        }

        public Criteria andGzlidIsNotNull() {
            addCriterion("gzlid is not null");
            return (Criteria) this;
        }

        public Criteria andGzlidEqualTo(Integer value) {
            addCriterion("gzlid =", value, "gzlid");
            return (Criteria) this;
        }

        public Criteria andGzlidNotEqualTo(Integer value) {
            addCriterion("gzlid <>", value, "gzlid");
            return (Criteria) this;
        }

        public Criteria andGzlidGreaterThan(Integer value) {
            addCriterion("gzlid >", value, "gzlid");
            return (Criteria) this;
        }

        public Criteria andGzlidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gzlid >=", value, "gzlid");
            return (Criteria) this;
        }

        public Criteria andGzlidLessThan(Integer value) {
            addCriterion("gzlid <", value, "gzlid");
            return (Criteria) this;
        }

        public Criteria andGzlidLessThanOrEqualTo(Integer value) {
            addCriterion("gzlid <=", value, "gzlid");
            return (Criteria) this;
        }

        public Criteria andGzlidIn(List<Integer> values) {
            addCriterion("gzlid in", values, "gzlid");
            return (Criteria) this;
        }

        public Criteria andGzlidNotIn(List<Integer> values) {
            addCriterion("gzlid not in", values, "gzlid");
            return (Criteria) this;
        }

        public Criteria andGzlidBetween(Integer value1, Integer value2) {
            addCriterion("gzlid between", value1, value2, "gzlid");
            return (Criteria) this;
        }

        public Criteria andGzlidNotBetween(Integer value1, Integer value2) {
            addCriterion("gzlid not between", value1, value2, "gzlid");
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

        public Criteria andLlgzlIsNull() {
            addCriterion("llgzl is null");
            return (Criteria) this;
        }

        public Criteria andLlgzlIsNotNull() {
            addCriterion("llgzl is not null");
            return (Criteria) this;
        }

        public Criteria andLlgzlEqualTo(Float value) {
            addCriterion("llgzl =", value, "llgzl");
            return (Criteria) this;
        }

        public Criteria andLlgzlNotEqualTo(Float value) {
            addCriterion("llgzl <>", value, "llgzl");
            return (Criteria) this;
        }

        public Criteria andLlgzlGreaterThan(Float value) {
            addCriterion("llgzl >", value, "llgzl");
            return (Criteria) this;
        }

        public Criteria andLlgzlGreaterThanOrEqualTo(Float value) {
            addCriterion("llgzl >=", value, "llgzl");
            return (Criteria) this;
        }

        public Criteria andLlgzlLessThan(Float value) {
            addCriterion("llgzl <", value, "llgzl");
            return (Criteria) this;
        }

        public Criteria andLlgzlLessThanOrEqualTo(Float value) {
            addCriterion("llgzl <=", value, "llgzl");
            return (Criteria) this;
        }

        public Criteria andLlgzlIn(List<Float> values) {
            addCriterion("llgzl in", values, "llgzl");
            return (Criteria) this;
        }

        public Criteria andLlgzlNotIn(List<Float> values) {
            addCriterion("llgzl not in", values, "llgzl");
            return (Criteria) this;
        }

        public Criteria andLlgzlBetween(Float value1, Float value2) {
            addCriterion("llgzl between", value1, value2, "llgzl");
            return (Criteria) this;
        }

        public Criteria andLlgzlNotBetween(Float value1, Float value2) {
            addCriterion("llgzl not between", value1, value2, "llgzl");
            return (Criteria) this;
        }

        public Criteria andSjgzlIsNull() {
            addCriterion("sjgzl is null");
            return (Criteria) this;
        }

        public Criteria andSjgzlIsNotNull() {
            addCriterion("sjgzl is not null");
            return (Criteria) this;
        }

        public Criteria andSjgzlEqualTo(Float value) {
            addCriterion("sjgzl =", value, "sjgzl");
            return (Criteria) this;
        }

        public Criteria andSjgzlNotEqualTo(Float value) {
            addCriterion("sjgzl <>", value, "sjgzl");
            return (Criteria) this;
        }

        public Criteria andSjgzlGreaterThan(Float value) {
            addCriterion("sjgzl >", value, "sjgzl");
            return (Criteria) this;
        }

        public Criteria andSjgzlGreaterThanOrEqualTo(Float value) {
            addCriterion("sjgzl >=", value, "sjgzl");
            return (Criteria) this;
        }

        public Criteria andSjgzlLessThan(Float value) {
            addCriterion("sjgzl <", value, "sjgzl");
            return (Criteria) this;
        }

        public Criteria andSjgzlLessThanOrEqualTo(Float value) {
            addCriterion("sjgzl <=", value, "sjgzl");
            return (Criteria) this;
        }

        public Criteria andSjgzlIn(List<Float> values) {
            addCriterion("sjgzl in", values, "sjgzl");
            return (Criteria) this;
        }

        public Criteria andSjgzlNotIn(List<Float> values) {
            addCriterion("sjgzl not in", values, "sjgzl");
            return (Criteria) this;
        }

        public Criteria andSjgzlBetween(Float value1, Float value2) {
            addCriterion("sjgzl between", value1, value2, "sjgzl");
            return (Criteria) this;
        }

        public Criteria andSjgzlNotBetween(Float value1, Float value2) {
            addCriterion("sjgzl not between", value1, value2, "sjgzl");
            return (Criteria) this;
        }

        public Criteria andOthergzlIsNull() {
            addCriterion("othergzl is null");
            return (Criteria) this;
        }

        public Criteria andOthergzlIsNotNull() {
            addCriterion("othergzl is not null");
            return (Criteria) this;
        }

        public Criteria andOthergzlEqualTo(Float value) {
            addCriterion("othergzl =", value, "othergzl");
            return (Criteria) this;
        }

        public Criteria andOthergzlNotEqualTo(Float value) {
            addCriterion("othergzl <>", value, "othergzl");
            return (Criteria) this;
        }

        public Criteria andOthergzlGreaterThan(Float value) {
            addCriterion("othergzl >", value, "othergzl");
            return (Criteria) this;
        }

        public Criteria andOthergzlGreaterThanOrEqualTo(Float value) {
            addCriterion("othergzl >=", value, "othergzl");
            return (Criteria) this;
        }

        public Criteria andOthergzlLessThan(Float value) {
            addCriterion("othergzl <", value, "othergzl");
            return (Criteria) this;
        }

        public Criteria andOthergzlLessThanOrEqualTo(Float value) {
            addCriterion("othergzl <=", value, "othergzl");
            return (Criteria) this;
        }

        public Criteria andOthergzlIn(List<Float> values) {
            addCriterion("othergzl in", values, "othergzl");
            return (Criteria) this;
        }

        public Criteria andOthergzlNotIn(List<Float> values) {
            addCriterion("othergzl not in", values, "othergzl");
            return (Criteria) this;
        }

        public Criteria andOthergzlBetween(Float value1, Float value2) {
            addCriterion("othergzl between", value1, value2, "othergzl");
            return (Criteria) this;
        }

        public Criteria andOthergzlNotBetween(Float value1, Float value2) {
            addCriterion("othergzl not between", value1, value2, "othergzl");
            return (Criteria) this;
        }

        public Criteria andGzlsumIsNull() {
            addCriterion("gzlsum is null");
            return (Criteria) this;
        }

        public Criteria andGzlsumIsNotNull() {
            addCriterion("gzlsum is not null");
            return (Criteria) this;
        }

        public Criteria andGzlsumEqualTo(Float value) {
            addCriterion("gzlsum =", value, "gzlsum");
            return (Criteria) this;
        }

        public Criteria andGzlsumNotEqualTo(Float value) {
            addCriterion("gzlsum <>", value, "gzlsum");
            return (Criteria) this;
        }

        public Criteria andGzlsumGreaterThan(Float value) {
            addCriterion("gzlsum >", value, "gzlsum");
            return (Criteria) this;
        }

        public Criteria andGzlsumGreaterThanOrEqualTo(Float value) {
            addCriterion("gzlsum >=", value, "gzlsum");
            return (Criteria) this;
        }

        public Criteria andGzlsumLessThan(Float value) {
            addCriterion("gzlsum <", value, "gzlsum");
            return (Criteria) this;
        }

        public Criteria andGzlsumLessThanOrEqualTo(Float value) {
            addCriterion("gzlsum <=", value, "gzlsum");
            return (Criteria) this;
        }

        public Criteria andGzlsumIn(List<Float> values) {
            addCriterion("gzlsum in", values, "gzlsum");
            return (Criteria) this;
        }

        public Criteria andGzlsumNotIn(List<Float> values) {
            addCriterion("gzlsum not in", values, "gzlsum");
            return (Criteria) this;
        }

        public Criteria andGzlsumBetween(Float value1, Float value2) {
            addCriterion("gzlsum between", value1, value2, "gzlsum");
            return (Criteria) this;
        }

        public Criteria andGzlsumNotBetween(Float value1, Float value2) {
            addCriterion("gzlsum not between", value1, value2, "gzlsum");
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