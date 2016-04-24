package com.tvajjala.vo;

import java.io.Serializable;

public class Training implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8825646974241476909L;

    private Long id;

    private String trainingTitle;

    private String trainerName;

    public Training() {
    }

    public Training(String title, String name) {
        trainingTitle = title;
        trainerName = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainingTitle() {
        return trainingTitle;
    }

    public void setTrainingTitle(String trainingTitle) {
        this.trainingTitle = trainingTitle;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Training [");
        if (trainingTitle != null) {
            builder.append("trainingTitle=");
            builder.append(trainingTitle);
            builder.append(", ");
        }
        if (trainerName != null) {
            builder.append("trainerName=");
            builder.append(trainerName);
        }
        builder.append("]");
        return builder.toString();
    }

}