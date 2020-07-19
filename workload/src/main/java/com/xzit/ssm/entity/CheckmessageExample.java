package com.xzit.ssm.entity;

import java.util.ArrayList;
import java.util.List;

public class CheckmessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CheckmessageExample() {
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

        public Criteria andKcidIsNull() {
            addCriterion("kcid is null");
            return (Criteria) this;
        }

        public Criteria andKcidIsNotNull() {
            addCriterion("kcid is not null");
            return (Criteria) this;
        }

        public Criteria andKcidEqualTo(Integer value) {
            addCriterion("kcid =", value, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidNotEqualTo(Integer value) {
            addCriterion("kcid <>", value, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidGreaterThan(Integer value) {
            addCriterion("kcid >", value, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidGreaterThanOrEqualTo(Integer value) {
            addCriterion("kcid >=", value, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidLessThan(Integer value) {
            addCriterion("kcid <", value, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidLessThanOrEqualTo(Integer value) {
            addCriterion("kcid <=", value, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidIn(List<Integer> values) {
            addCriterion("kcid in", values, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidNotIn(List<Integer> values) {
            addCriterion("kcid not in", values, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidBetween(Integer value1, Integer value2) {
            addCriterion("kcid between", value1, value2, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidNotBetween(Integer value1, Integer value2) {
            addCriterion("kcid not between", value1, value2, "kcid");
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

        public Criteria andMsgIsNull() {
            addCriterion("msg is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsNotNull() {
            addCriterion("msg is not null");
            return (Criteria) this;
        }

        public Criteria andMsgEqualTo(String value) {
            addCriterion("msg =", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotEqualTo(String value) {
            addCriterion("msg <>", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThan(String value) {
            addCriterion("msg >", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThanOrEqualTo(String value) {
            addCriterion("msg >=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThan(String value) {
            addCriterion("msg <", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThanOrEqualTo(String value) {
            addCriterion("msg <=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLike(String value) {
            addCriterion("msg like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotLike(String value) {
            addCriterion("msg not like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgIn(List<String> values) {
            addCriterion("msg in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotIn(List<String> values) {
            addCriterion("msg not in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgBetween(String value1, String value2) {
            addCriterion("msg between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotBetween(String value1, String value2) {
            addCriterion("msg not between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andHandleIsNull() {
            addCriterion("handle is null");
            return (Criteria) this;
        }

        public Criteria andHandleIsNotNull() {
            addCriterion("handle is not null");
            return (Criteria) this;
        }

        public Criteria andHandleEqualTo(String value) {
            addCriterion("handle =", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotEqualTo(String value) {
            addCriterion("handle <>", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleGreaterThan(String value) {
            addCriterion("handle >", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleGreaterThanOrEqualTo(String value) {
            addCriterion("handle >=", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleLessThan(String value) {
            addCriterion("handle <", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleLessThanOrEqualTo(String value) {
            addCriterion("handle <=", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleLike(String value) {
            addCriterion("handle like", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotLike(String value) {
            addCriterion("handle not like", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleIn(List<String> values) {
            addCriterion("handle in", values, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotIn(List<String> values) {
            addCriterion("handle not in", values, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleBetween(String value1, String value2) {
            addCriterion("handle between", value1, value2, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotBetween(String value1, String value2) {
            addCriterion("handle not between", value1, value2, "handle");
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