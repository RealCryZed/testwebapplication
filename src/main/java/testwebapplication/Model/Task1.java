package testwebapplication.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task1")
public class Task1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String sequence1;
    private String sequence2;
}
