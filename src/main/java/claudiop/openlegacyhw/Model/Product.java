package claudiop.openlegacyhw.Model;

import javax.persistence.*;

@Entity
@Table (name = "Items")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemNumber;

    @Column(name = "itemName")
    private String itemName;

    @Column(name = "amount")
    private Long amount;


    @Column(name = "itemCode")
    private String itemCode;



    public Long getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Long itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
