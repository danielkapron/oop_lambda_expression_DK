package distance_calculator;
// 1. Konstruktor implementujący wartości x i y
// 2. Konstruktor domyślny implementujący wartości x = 0 i y = 0
// 3. Gettery, settery
// 4. Inkrementacja i dekrementacja składowych x i y (wywołanie x, zrobi x++ )
// 5. toString - [x,y]

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data

public class Point {

    private Integer x;
    private Integer y;


    public Point(){
        this.x = 0;
        this.y = 0;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }

    public void incrementX(int x){
        this.x++;
    }
    public void decrementX(int x){
        this.x--;
    }
    public void incrementY(int y){
        this.y++;
    }
    public void decrementY(int y){
        this.y--;
    }

}
