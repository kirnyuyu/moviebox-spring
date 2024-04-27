package com.kh.moviebox.common.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Setter
@ToString
public class Price {
	private int studentCount;
	private int commonCount;
	private int studentPrice;
	private int commonPrice;
	private int totalPrice;
}
