package com.tapusd.hexarchdemo.application.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.tapusd.hexarchdemo.domain.Product;

public record AddProductRequest(@JsonCreator Product product) {
}
