package cs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Persistence;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class App {
    private static EntityManagerFactory emf;
    @Autowired
    private static ChilDao cDao;
    @Autowired
    private static Cookie coDao;
    @Autowired
    private static EatsDao eDao;
    @Autowired
    private static EatsService ser;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        System.out.println("--------TESTING-------");
        // coDao.
        // Cookie cokCookie = coDao.
        // coDao.
        // Child cokCookie = new Cookie();
        // EatsService s = new EatsService();
        ser = new EatsService(null);
        ser.create(null, null, null);
    }
}

@Aspect
@Component
class ChocolateChipLover {
    @Autowired
    private CookieDao cookieDao;
    @Around("execution(* cs.App.EatsService.create(..))")
    public Object beforeTrace(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        Long cookieId = (Long) args[1];
        Cookie cookie = cookieDao.findById(cookieId).get();
        if (cookie instanceof ChocolateChip) {
            System.out.println("inside if");
            args[2] = "Great";
        }
        return jp.proceed(args);
    }
}

@Service
@Transactional
class EatsService {
    // @Autowired
    private EatsDao eatsDao;
    public EatsService(EatsDao eatsDao){
        this.eatsDao = eatsDao;
    }
    // @Autowired
    // private ChilDao childDao;
    // @Autowired
    // private CookieDao cookieDao;

    public void create(Long childId, Long cookieId, String enjoyment) {
        // Child child = childDao.findById(childId).get();
        // Cookie cookie = cookieDao.findById(cookieId).get();
        Eats eats = new Eats(null, new Date(), enjoyment);
        eatsDao.save(eats);
        // child.getEats().add(eats); // I'm okay with them forgetting this
    }
}

@Data
@Entity
class Child {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    @Embedded
    private Address address;
    @OneToMany
    private List<Eats> eats = new ArrayList<>();
}

@Data
@Embeddable
class Address {
    private String city;
    private String country;
}

@Data
@Entity
class Eats {
    public Eats(Object object, Date date2, String enjoyment2) {
        this.date = date2;
        this.enjoyment = enjoyment2;
    }
    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String enjoyment;
    @ManyToOne
    // @JsonManagedReference
    private Cookie cookie;
}

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
class Cookie {
    @Id
    @GeneratedValue
    private Long id;
    private double size;
    @OneToMany(mappedBy = "cookie")
    @JsonBackReference
    private List<Eats> eats = new ArrayList<>();
}

@Data
@Entity
class ChocolateChip extends Cookie {
    private int numberotchips;
}

@Data
@Entity
class Shortbread extends Cookie {
    private String extraingredient;
}

@Data
@Entity
class Thumbprint extends Cookie {
    private String jamType;
}

interface EatsDao extends JpaRepository<Eats, Long> {
    public Eats findByEnjoyment(String enjoyment);

    public List<Eats> findByCookieId(Long id);
}

interface CookieDao extends JpaRepository<Cookie, Long> {
}

interface ChilDao extends JpaRepository<Child, Long> {
}
