package com.demo.version.features.feat17;

// restrict which classes can extend or implement a type, constraint on inheritance
public sealed interface Shape permits Circle, Square {

}
