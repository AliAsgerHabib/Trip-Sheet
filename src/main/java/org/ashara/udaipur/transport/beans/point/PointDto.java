package org.ashara.udaipur.transport.beans.point;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PointDto {
    private Integer pointId;
    private String name;
    private String zonalHeadName;
    private String zonalHeadEmail;
    private String zonalHeadContactNo;
}