package com.wstutorial.ws;

import com.wstutorial.ws.commonservice.AcknowledgementCode;
import com.wstutorial.ws.sellerservice.*;

import java.util.ArrayList;
import java.util.List;

public class SellerRepository {

    List<Seller> sellers = new ArrayList<>();

    public SellerRepository() {
        Seller sel1 = new Seller();
        sel1.setPhoneNumber("01796092925");
        sel1.setId(101l);
        sel1.setName("Md Siam");
        sel1.setEmail("bsse1104@iit.du.ac.bd");
        sel1.setBank("1041050077232");
        sel1.setTinNumber("123");


        Seller sel2 = new Seller();
        sel2.setPhoneNumber("01518988953");
        sel2.setId(102l);
        sel2.setName("Ashaduzzaman Nur");
        sel2.setEmail("something@iit.du.ac.bd");
        sel2.setBank("122211224223");
        sel2.setTinNumber("222");

        sellers.add(sel1);
        sellers.add(sel2);
    }
    public List<Seller> getSellers() {
        return sellers;
    }

    public Seller getSellerById(Long id) {
        for(Seller c: sellers) {
            if(c.getId() == id) {
                return c;
            }
        }
        System.out.println("can not delete: seller not found with id: " + id);
        return null;
    }

    public AcknowledgementCode deleteSellerById(Long id) {

        for(Seller c: sellers) {
            if(c.getId() == id) {
                sellers.remove(c);
                return AcknowledgementCode.DELETED;
            }
        }
        System.out.println("can not delete: seller not found with id: " + id);
        return AcknowledgementCode.FAILED;
    }

    public AcknowledgementCode updateSellerById(Long id, Seller seller) {
        if (id == null || seller == null) {
            System.out.println("Invalid input: id or seller is null");
            return AcknowledgementCode.FAILED;
        }

        for (int i = 0; i < sellers.size(); i++) {
            Long sellerId = sellers.get(i).getId();
            if (sellerId.equals(id)) {
                sellers.set(i, seller);
                return AcknowledgementCode.UPDATED;
            }
        }
        System.out.println("Cannot update: seller not found with id: " + id);
        return AcknowledgementCode.FAILED;
    }


    public void createNewSeller(Seller seller) {
        seller.setId(sellers.size()+101);
        sellers.add(seller);
    }

}
