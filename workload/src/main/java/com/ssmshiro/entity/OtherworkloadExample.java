package com.ssmshiro.entity;

import java.util.ArrayList;
import java.util.List;

public class OtherworkloadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OtherworkloadExample() {
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

        public Criteria andOtheridIsNull() {
            addCriterion("otherid is null");
            return (Criteria) this;
        }

        public Criteria andOtheridIsNotNull() {
            addCriterion("otherid is not null");
            return (Criteria) this;
        }

        public Criteria andOtheridEqualTo(Integer value) {
            addCriterion("otherid =", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridNotEqualTo(Integer value) {
            addCriterion("otherid <>", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridGreaterThan(Integer value) {
            addCriterion("otherid >", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("otherid >=", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridLessThan(Integer value) {
            addCriterion("otherid <", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridLessThanOrEqualTo(Integer value) {
            addCriterion("otherid <=", value, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridIn(List<Integer> values) {
            addCriterion("otherid in", values, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridNotIn(List<Integer> values) {
            addCriterion("otherid not in", values, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridBetween(Integer value1, Integer value2) {
            addCriterion("otherid between", value1, value2, "otherid");
            return (Criteria) this;
        }

        public Criteria andOtheridNotBetween(Integer value1, Integer value2) {
            addCriterion("otherid not between", value1, value2, "otherid");
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

        public Criteria andGzlmcIsNull() {
            addCriterion("gzlmc is null");
            return (Criteria) this;
        }

        public Criteria andGzlmcIsNotNull() {
            addCriterion("gzlmc is not null");
            return (Criteria) this;
        }

        public Criteria andGzlmcEqualTo(String value) {
            addCriterion("gzlmc =", value, "gzlmc");
            return (Criteria) this;
        }

        public Criteria andGzlmcNotEqualTo(String value) {
            addCriterion("gzlmc <>", value, "gzlmc");
            return (Criteria) this;
        }

        public Criteria andGzlmcGreaterThan(String value) {
            addCriterion("gzlmc >", value, "gzlmc");
            return (Criteria) this;
        }

        public Criteria andGzlmcGreaterThanOrEqualTo(String value) {
            addCriterion("gzlmc >=", value, "gzlmc");
            return (Criteria) this;
        }

        public Criteria andGzlmcLessThan(String value) {
            addCriterion("gzlmc <", value, "gzlmc");
            return (Criteria) this;
        }

        public Criteria andGzlmcLessThanOrEqualTo(String value) {
            addCriterion("gzlmc <=", value, "gzlmc");
            return (Criteria) this;
        }

        public Criteria andGzlmcLike(String value) {
            addCriterion("gzlmc like", value, "gzlmc");
            return (Criteria) this;
        }

        public Criteria andGzlmcNotLike(String value) {
            addCriterion("gzlmc not like", value, "gzlmc");
            return (Criteria) this;
        }

        public Criteria andGzlmcIn(List<String> values) {
            addCriterion("gzlmc in", values, "gzlmc");
            return (Criteria) this;
        }

        public Criteria andGzlmcNotIn(List<String> values) {
            addCriterion("gzlmc not in", values, "gzlmc");
            return (Criteria) this;
        }

        public Criteria andGzlmcBetween(String value1, String value2) {
            addCriterion("gzlmc between", value1, value2, "gzlmc");
            return (Criteria) this;
        }

        public Criteria andGzlmcNotBetween(String value1, String value2) {
            addCriterion("gzlmc not between", value1, value2, "gzlmc");
            return (Criteria) this;
        }

        public Criteria andGzlIsNull() {
            addCriterion("gzl is null");
            return (Criteria) this;
        }

        public Criteria andGzlIsNotNull() {
            addCriterion("gzl is not null");
            return (Criteria) this;
        }

        public Criteria andGzlEqualTo(Float value) {
            addCriterion("gzl =", value, "gzl");
            return (Criteria) this;
        }

        public Criteria andGzlNotEqualTo(Float value) {
            addCriterion("gzl <>", value, "gzl");
            return (Criteria) this;
        }

        public Criteria andGzlGreaterThan(Float value) {
            addCriterion("gzl >", value, "gzl");
            return (Criteria) this;
        }

        public Criteria andGzlGreaterThanOrEqualTo(Float value) {
            addCriterion("gzl >=", value, "gzl");
            return (Criteria) this;
        }

        public Criteria andGzlLessThan(Float value) {
            addCriterion("gzl <", value, "gzl");
            return (Criteria) this;
        }

        public Criteria andGzlLessThanOrEqualTo(Float value) {
            addCriterion("gzl <=", value, "gzl");
            return (Criteria) this;
        }

        public Criteria andGzlIn(List<Float> values) {
            addCriterion("gzl in", values, "gzl");
            return (Criteria) this;
        }

        public Criteria andGzlNotIn(List<Float> values) {
            addCriterion("gzl not in", values, "gzl");
            return (Criteria) this;
        }

        public Criteria andGzlBetween(Float value1, Float value2) {
            addCriterion("gzl between", value1, value2, "gzl");
            return (Criteria) this;
        }

        public Criteria andGzlNotBetween(Float value1, Float value2) {
            addCriterion("gzl not between", value1, value2, "gzl");
            return (Criteria) this;
        }

        public Criteria andBriefIsNull() {
            addCriterion("brief is null");
            return (Criteria) this;
        }

        public Criteria andBriefIsNotNull() {
            addCriterion("brief is not null");
            return (Criteria) this;
        }

        public Criteria andBriefEqualTo(String value) {
            addCriterion("brief =", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotEqualTo(String value) {
            addCriterion("brief <>", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThan(String value) {
            addCriterion("brief >", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThanOrEqualTo(String value) {
            addCriterion("brief >=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThan(String value) {
            addCriterion("brief <", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThanOrEqualTo(String value) {
            addCriterion("brief <=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLike(String value) {
            addCriterion("brief like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotLike(String value) {
            addCriterion("brief not like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefIn(List<String> values) {
            addCriterion("brief in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotIn(List<String> values) {
            addCriterion("brief not in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefBetween(String value1, String value2) {
            addCriterion("brief between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotBetween(String value1, String value2) {
            addCriterion("brief not between", value1, value2, "brief");
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