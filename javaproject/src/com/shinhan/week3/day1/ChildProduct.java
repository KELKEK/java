package com.shinhan.week3.day1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//상속
@Getter
@Setter
@NoArgsConstructor
public class ChildProduct<K, V, P> extends Product<K, V> {// 부모한테서 K,V 물려받음
	P price;

	public ChildProduct(K kind, V model, P price) {
		super(kind, model);
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("model : ").append(getModel()).append("\nkind : ").append(getKind()).append("\nprice : ").append(price);
		return builder.toString();
	}
	
}
