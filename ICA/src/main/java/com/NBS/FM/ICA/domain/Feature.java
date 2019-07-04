package com.NBS.FM.ICA.domain;

public class Feature {
    private int ft_id;
    private String ft_name_v ;
    private String ft_toggle_name_v ;
    private int ap_id;
    private boolean in_use_z;
    
	public int getFt_id() {
		return ft_id;
	}
	public void setFt_id(int ft_id) {
		this.ft_id = ft_id;
	}
	public String getFt_name_v() {
		return ft_name_v;
	}
	public void setFt_name_v(String ft_name_v) {
		this.ft_name_v = ft_name_v;
	}
	public String getFt_toggle_name_v() {
		return ft_toggle_name_v;
	}
	public void setFt_toggle_name_v(String ft_toggle_name_v) {
		this.ft_toggle_name_v = ft_toggle_name_v;
	}
	public int getAp_id() {
		return ap_id;
	}
	public void setAp_id(int ap_id) {
		this.ap_id = ap_id;
	}
	public boolean isIn_use_z() {
		return in_use_z;
	}
	public void setIn_use_z(boolean in_use_z) {
		this.in_use_z = in_use_z;
	}    

}
