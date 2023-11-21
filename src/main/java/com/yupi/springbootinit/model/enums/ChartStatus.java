package com.yupi.springbootinit.model.enums;

/**
 * 自定义错误码
 *
*
 */
public enum ChartStatus {

    WAIT("wait"),
    RUNNING("running"),
    SUCCESS( "succeed"),
    FAILED("failed");



    /**
     * 信息
     */
    private final String message;

    ChartStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
