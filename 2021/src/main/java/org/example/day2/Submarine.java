package org.example.day2;

public class Submarine {
    private Long depth = 0L;
    private Long horizontalPosition = 0L;
    private Long aim = 0L;

    public void basicMove(Direction direction, Long amount) {
        switch(direction) {
            case down:
                incrementDepth(amount);
                break;
            case up:
                incrementDepth(-1 * amount);
                break;
            case forward:
                incrementHorizontalPosition(amount);
                break;
            default:
                break;
        }
    }

    public void moreAccurateMove(Direction direction, Long amount) {
        switch(direction) {
            case down:
                incrementAim(amount);
                break;
            case up:
                incrementAim(-1 * amount);
                break;
            case forward:
                incrementHorizontalPosition(amount);
                incrementDepth(amount * aim);
                break;
            default:
                break;
        }
    }

    public void resetPosition() {
        this.depth = 0L;
        this.horizontalPosition = 0L;
    }

    public Long getHorizontalPosition() {
        return horizontalPosition;
    }

    public Long getDepth() {
        return depth;
    }

    private void incrementDepth(Long depth) {
        this.depth = this.depth + depth;
    }

    private void incrementAim(Long aim) {
        this.aim = this.aim + aim;
    }

    private void incrementHorizontalPosition(Long horizontalPosition) {
        this.horizontalPosition = this.horizontalPosition + horizontalPosition;
    }

    public Long getFinalPosition() {
        return this.depth * this.horizontalPosition;
    }
}
