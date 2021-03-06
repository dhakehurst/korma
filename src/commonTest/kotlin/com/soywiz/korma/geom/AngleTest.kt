package com.soywiz.korma.geom

import kotlin.math.*
import kotlin.test.*

class AngleTest {
    @Test
    fun testAngleTo() {
        //assertEquals(Angle.fromDegrees(0.0), Point2d(0, 0).angleTo(Point2d(100, 0)))
        //assertEquals(Angle.fromDegrees(90.0), Point2d(0, 0).angleTo(Point2d(0, 100)))
        //assertEquals(Angle.fromDegrees(180.0), Point2d(0, 0).angleTo(Point2d(-100, 0)))
        //assertEquals(Angle.fromDegrees(270.0), Point2d(0, 0).angleTo(Point2d(0, -100)))
//
        //assertEquals(Angle.fromDegrees(0.0), Point2d(1000, 1000).angleTo(Point2d(1000 + 100, 1000 + 0)))
        //assertEquals(Angle.fromDegrees(90.0), Point2d(1000, 1000).angleTo(Point2d(1000 + 0, 1000 + 100)))
        //assertEquals(Angle.fromDegrees(180.0), Point2d(1000, 1000).angleTo(Point2d(1000 + -100, 1000 + 0)))
        //assertEquals(Angle.fromDegrees(270.0), Point2d(1000, 1000).angleTo(Point2d(1000 + 0, 1000 + -100)))
    }

    @Test
    fun testAngleOps() {

        assertEquals(180.degrees, 90.degrees + 90.degrees)
        assertEquals(180.degrees, 90.degrees * 2)
        assertEquals(45.degrees, 90.degrees / 2)
        assertEquals(2.0, 90.degrees / 45.degrees)

        assertEquals(0.degrees, (360 * 2.0).degrees.normalized)
        assertEquals(0.0, (360 * 2.0).degrees.normalized.degrees)
        assertEquals(0.0, (360 * 2.0).degrees.normalized.radians)

        assertEquals((-90).degrees, -(90.degrees))
        assertEquals((+90).degrees, +(90.degrees))

        assertEquals(90.degrees, (-(90).degrees).absoluteValue)

        assertEquals(0.degrees, 360.degrees.normalized)

        //assertEquals(90.degrees, 180.degrees - 90.degrees)
    }

    @Test
    fun sinCos() {
        assertEquals(0.0, cos(90.degrees))
        assertEquals(1.0, sin(90.degrees))
        assertEquals(1.0, tan(45.degrees))
    }

    @Test
    fun between() {
        assertEquals(0.degrees, Angle.between(Point(0, 0), Point(10, 0)))
        assertEquals(90.degrees, Angle.between(Point(0, 0), Point(0, 10)))
        assertEquals(180.degrees, Angle.between(Point(0, 0), Point(-10, 0)))
        assertEquals(270.degrees, Angle.between(Point(0, 0), Point(0, -10)))

        assertEquals(0.degrees, Angle.between(100, 100, 110, 100))
        assertEquals(90.degrees, Angle.between(100, 100, 100, 110))
        assertEquals(180.degrees, Angle.between(100, 100, -110, 100))
        assertEquals(270.degrees, Angle.between(100, 100, 100, -110))
    }

    @Test
    fun ops() {

    }

    // @TODO: Required to avoid: java.lang.AssertionError: expected:<3.141592653589793> but was:<Angle(180.0)>
    private fun assertEquals(a: Angle, b: Angle) {
        assertEquals(a.degrees, b.degrees)
    }

    private fun assertEquals(l: Double, r: Double, epsilon: Double = 0.00001) {
        assertTrue(abs(l - r) < epsilon, message = "$l != $r :: delta=$epsilon")
    }
}
