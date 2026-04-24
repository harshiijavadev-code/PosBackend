package harshjava.productcutsomerapi.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Category {

    @Column(nullable = false,length = 100,unique = true)
    private String name ;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String description;

@CreationTimestamp
@Column(name = "createdat",nullable = false,updatable = false)
    private LocalDateTime CreatedAT;
@UpdateTimestamp
@Column(name ="updatedAT", nullable = false)
    private LocalDateTime UpdatedAT;

// fetch = FetchType.LAZY means products are NOT loaded from the DB until you
    //   explicitly access this list. This is critical for performance — without LAZY,
    //   every Category query would also pull all products.
    // orphanRemoval = true means if you remove a Product from this list, it gets
    //   deleted from the DB automatically.


@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)

@Builder.Default
private List<Product> products= new ArrayList<>();
}
