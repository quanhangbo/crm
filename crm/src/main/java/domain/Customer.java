package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Customer {
    private long custId;
    private String custName;
    private String custSource;
    private Integer custLinkman;
    private String custPhone;
    private String custMobile;

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custLinkman='" + custLinkman + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custMobile='" + custMobile + '\'' +
                '}';
    }

    @Id
    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    @Basic
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }


    @Basic
    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }


    @Basic
    public Integer getCustLinkman() {
        return custLinkman;
    }

    public void setCustLinkman(Integer custLinkman) {
        this.custLinkman = custLinkman;
    }

    @Basic
    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Basic
    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer that = (Customer) o;
        return custId == that.custId &&
                Objects.equals(custName, that.custName) &&
                Objects.equals(custSource, that.custSource) &&
                Objects.equals(custLinkman, that.custLinkman) &&
                Objects.equals(custPhone, that.custPhone) &&
                Objects.equals(custMobile, that.custMobile);
    }

    @Override
    public int hashCode() {

        return Objects.hash(custId, custName, custSource,custLinkman, custPhone, custMobile);
    }
}
