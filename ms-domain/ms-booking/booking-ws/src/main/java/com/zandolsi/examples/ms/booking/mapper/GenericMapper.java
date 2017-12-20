package com.zandolsi.examples.ms.booking.mapper;

import java.util.List;

public interface GenericMapper<L, R> {

    R to(L left);

    L from(R right);

    List<R> toList(List<L> left);

    List<L> fromList(List<R> right);
}
