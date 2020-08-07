import java.util.Arrays;

/**
 * 아래 테스트 코드가 정상 동작하도록 클래스들을 완성하시오.
 *
 * getArea(): 사각형의 넓이를 반환한다.
 * getCenterOfMass(): 사각형의 질량중심을 반환한다.
 * GetAllPoints(): 사각형의 네 점을 배열로 반환한다.
 * rot90(): Pivot을 기준으로 사각형을 90도 회전시킨다.
 */

class Vector2D {
    public float x, y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "" + this.x + ", " + this.y;
    }
}

class RectCore {
    protected Vector2D pos;
    protected float w, h;

    public RectCore(float x, float y, float w, float h) {
        this.pos = new Vector2D(x, y);
        this.w = w;
        this.h = h;
    }

    public String toString() {
        return "RectCore(" + this.pos + ", " + w + ", " + h + ")";
    }
}

public class Rect extends RectCore {
    public Rect(float x, float y, float w, float h) {
        super(x, y, w, h);
    }

    public float getArea() {
        return w * h;
    }

    public Vector2D getCenterOfMass() {
        return new Vector2D(pos.x + w / 2.0f, pos.y + h / 2.0f);
    }

    public Vector2D [] getAllPoints() {
        return new Vector2D[] {
                pos,
                new Vector2D(pos.x + w, pos.y),
                new Vector2D(pos.x, pos.y + h),
                new Vector2D(pos.x + w, pos.y + h)
        };
    }

    public void rot90(Vector2D pivot) {
        Vector2D [] oldPoints = getAllPoints();
        Vector2D [] newPoints = new Vector2D[4];
        for (int i = 0; i < oldPoints.length; i++) {
            newPoints[i] = new Vector2D(
                    -(oldPoints[i].y - pivot.y) + pivot.x,
                    (oldPoints[i].x - pivot.x) + pivot.y
            );
        }

        float min_x = newPoints[0].x;
        float min_y = newPoints[0].y;
        float max_x = newPoints[0].x;
        float max_y = newPoints[0].y;
        for (Vector2D vector2D: newPoints) {
            min_x = Math.min(vector2D.x, min_x);
            min_y = Math.min(vector2D.y, min_y);
            max_x = Math.max(vector2D.x, max_x);
            max_y = Math.max(vector2D.y, max_y);
        }

        pos = new Vector2D(min_x, min_y);
        w = max_x - min_x;
        h = max_y - min_y;
    }

    public String toString() {
        String s = super.toString();
        s += "\nArea: " + getArea();
        s += "\nCoM: " + getCenterOfMass();
        s += "\n";
        return s;
    }
}

class RectTest {
    public static void main(String[] args) {
        Rect rect = new Rect(0.5f, 0.7f, 1.5f, 2.3f);
        System.out.println("Area: " + rect.getArea());
        System.out.println("CoM: " + rect.getCenterOfMass());
        System.out.println("All Points: " + Arrays.toString(rect.getAllPoints()));

        rect.rot90(new Vector2D(0.4f, 0.2f));
        System.out.println("Rotated rect: " + rect);
    }
}