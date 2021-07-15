package com.jy.flowSort;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlowBean implements WritableComparable<FlowBean> {
    private Integer upFlow;
    private Integer downFlow;
    private Integer sumFlow = 0;

    public FlowBean() {
    }

    public Integer getUpFlow() {
        return upFlow;
    }

    public Integer getDownFlow() {
        return downFlow;
    }

    public void setUpFlow(Integer upFlow) {
        this.upFlow = upFlow;
    }

    public void setDownFlow(Integer downFlow) {
        this.downFlow = downFlow;
    }

    public Integer getSumFlow() {
        return sumFlow;
    }

    public void setSumFlow(Integer sumFlow) {
        this.sumFlow = sumFlow;
    }
    //    @Override
//    public int compareTo(Object o) {
//        return (FlowBean)o.get;
//    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.upFlow);
        dataOutput.writeInt(this.downFlow);
        dataOutput.writeInt(this.sumFlow);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.upFlow = dataInput.readInt();
        this.downFlow = dataInput.readInt();
        this.sumFlow = dataInput.readInt();
    }

    @Override
    public String toString() {
        return  upFlow +
                "\t" + downFlow +
                "\t" + sumFlow;
    }

    @Override
    public int compareTo(FlowBean o) {
        return this.getSumFlow() - o.getSumFlow();
    }
}
