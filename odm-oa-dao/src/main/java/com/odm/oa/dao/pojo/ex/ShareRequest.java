package com.odm.oa.dao.pojo.ex;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShareRequest {
	private String sharePersonNames[];
	private Integer shareRefId;
	private String shareType;
}
