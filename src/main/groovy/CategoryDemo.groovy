@Category(Number)
class NumberCategory {
    public Number cube() {
        return this*this*this
    }
    
    public int divideWithRoundUp(BigDecimal divisor, boolean isRoundUp) {
        def mathRound = isRoundUp ? BigDecimal.ROUND_UP : BigDecimal.ROUND_DOWN
        return (int)new BigDecimal(this).divide(divisor, 0, mathRound)
    }
}

use (NumberCategory) {
    assert 3.cube() == 27
    assert 25.divideWithRoundUp(6, true) == 5
    assert 120.23.divideWithRoundUp(6.1, true) == 20
    assert 150.9.divideWithRoundUp(12.1, false) == 12
}