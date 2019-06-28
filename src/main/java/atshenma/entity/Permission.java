package atshenma.entity;

import lombok.Data;

@Data
public class Permission {
	private Integer id;
	// 权限名称
	private String permName;
	// 权限标识
	private String permTag;
	// 请求url
	private String url;

	@Override
	public String toString() {
		return "Permission{" +
				"id=" + id +
				", permName='" + permName + '\'' +
				", permTag='" + permTag + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}


