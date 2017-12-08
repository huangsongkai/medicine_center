package com.medicineCenter.model.dto;

/**
 * Created by Administrator on 2016/10/8.
 */
public class TaskQueryNumberDTO {
    private int processing;//处理中
    private int generate;//已生成
    private int change;//变更中

    public int getProcessing() {
        return processing;
    }

    public void setProcessing(int processing) {
        this.processing = processing;
    }

    public int getGenerate() {
        return generate;
    }

    public void setGenerate(int generate) {
        this.generate = generate;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }
}