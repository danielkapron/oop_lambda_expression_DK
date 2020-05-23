package distance_calculator;

import lombok.Getter;
import lombok.Setter;

// Rozszerzenie Point o składową Z

@Getter
@Setter
public class Point3D extends Point {

    private Integer z;

    public Point3D(Integer x, Integer y, Integer z) {
        super(x, y);
        this.z = z;
    }

    public Point3D(){
        super();
        this.z = 0;
    }

    @Override
    public String toString() {
        return "[" + super.getX() + "," + super.getY() + "," + this.z + "]";
    }

    public void incrementY(int z){
        this.z++;
    }
    public void decrementY(int z){
        this.z--;
    }

}
