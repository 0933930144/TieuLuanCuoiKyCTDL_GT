package DuongXuanKhai;
import java.util.Scanner;
import java.util.*;
import java.lang.*;
public class main 
{
    void clearScreen() 
    {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    }
    boolean k=false;
    Scanner tt=new Scanner(System.in);
    Node root;
    Node p1;
    void BinarySearchTree() 
    {  
        root = null;  
    }
    Node insertRec(Node newkey, DT tam) 
    {
        if (newkey == null) 
        { 
            newkey = new Node(tam); 
            return newkey; 
        }
        if (tam.ma.compareTo(newkey.data.ma)<0) 
           newkey.left = insertRec(newkey.left, tam); 
        else if (tam.ma.compareTo(newkey.data.ma)>0)  
           newkey.right = insertRec(newkey.right, tam);
        return newkey;  
    }
    void xuat(Node root) 
    { 
        if(root==null)
            return;
        if (root != null) 
        { 
            xuat(root.left); 
            System.out.println("Loai : "+root.data.loai+",Ma : "+root.data.ma+",Ten : "+root.data.ten+", Gia nhap : "+root.data.giaNhap+"(vnd), So luong : "+root.data.soLuong+",Ngay nhap : "+root.data.ngay); 
            xuat(root.right); 
        } 
    }
    void searchMa(Node root1,String ma)  
    { 
        if (root1.data.ma.compareTo(ma)==0) 
        {
            k=true;
            return;
        }
        if (root1.data.ma.compareTo(ma)>0 && root1.left!=null)  
            searchMa(root1.left, ma); 
        if(root1.right!=null)
            searchMa(root1.right, ma); 
    }
    void themHangHoa()
    {
        String ma="",ten="",loai="";
        int giaNhap=0,soLuong=0,ngay=0;
        tt.nextLine();
        System.out.print("Nhap ma hang hoa : ");
        ma=tt.nextLine();
        if(root!=null)
            searchMa(root,ma);    
        if(k==true)
            System.out.println("Loi trung ma voi hang hoa khac !");
            else
            {
                System.out.print("Nhap loai hang hoa : ");
                loai=tt.nextLine();
                System.out.print("Nhap ten hang hoa : ");
                ten=tt.nextLine();
                System.out.print("Nhap gia nhap hang hoa : ");
                giaNhap=tt.nextInt();
                System.out.print("Nhap so luong hang hoa ton kho : ");
                soLuong=tt.nextInt();
                System.out.print("Nhap ngay nhap hang hoa : ");
                ngay=tt.nextInt();
                DT tam=new DT(loai,ma,ten,giaNhap,soLuong,ngay);
                root=insertRec(root, tam);
                System.out.println("Them moi hang hoa thanh cong");
            }
        k=false;
        ma=tt.nextLine();
    }
    void deleteKey(String ma) 
    { 
        root = deleteRec(root, ma); 
    }   
    Node deleteRec(Node t, String ma) 
    { 
        if (t == null)  return t; 
        if (ma.compareTo(t.data.ma)<0) 
            t.left = deleteRec(t.left, ma); 
            else if (ma.compareTo(t.data.ma)>0)
                t.right = deleteRec(t.right, ma); 
                else
                { 
                    k=true;
                    if (t.left == null) 
                        return t.right; 
                        else if (t.right == null) 
                    return t.left; 
                    t.data = minValue(t.right); 
                    t.right = deleteRec(t.right, t.data.ma); 
                } 

        return t; 
    } 

    DT minValue(Node t) 
    { 
        DT minv = t.data; 
        while (t.left != null) 
        { 
            minv = t.left.data; 
            t = t.left; 
        } 
            return minv; 
    } 
    void xoaHangHoa()
    {
        String ma;
        int giaNhap,soLuong,ngay;
        tt.nextLine();
        System.out.print("Nhap ma hang hoa can xoa: ");
        ma=tt.nextLine();
        deleteKey(ma);
        if(k==true)
            System.out.println("Xoa thanh cong ");
            else System.out.println("Khong ton tai hang hoa co ma la "+ma);
        k=false;
        ma=tt.nextLine();
    }
    void update(Node t,String ma)
    { 
        if (t.data.ma.compareTo(ma)==0) 
        {
            k=true;
            String g;
            int choice;
            do
            {
                clearScreen(); 
                System.out.print("-------------Menu-Update-------------\n1. Cap nhat loai hang hoa\n2. Cap nhat ten hang hoa\n3. Cap nhat gia nhap\n4. Cap nhap ngay nhap hang hoa\n5. Quay ve Menu-1\nHay chon...");
                choice=tt.nextInt();
                tt.nextLine();
                switch (choice)
                {
                    case 1:
                    {
                        System.out.print("Nhap loai hang hoa moi : ");
                        t.data.loai=tt.nextLine();
                        System.out.println("Cap nhat loai hang hoa thanh cong ");
                        g=tt.nextLine();
                        break;
                    }
                    case 2:
                    {
                        System.out.print("Nhap ten hang hoa moi : ");
                        t.data.ten=tt.nextLine();
                        System.out.println("Cap nhat ten hang hoa thanh cong ");
                        g=tt.nextLine();
                        break;
                    }
                    case 3:
                    {
                        System.out.print("Nhap gia hang hoa moi : ");
                        t.data.giaNhap=tt.nextInt();
                        System.out.println("Cap nhat gia hang hoa thanh cong ");
                        g=tt.nextLine();
                        g=tt.nextLine();
                        break;
                    }
                    case 4:
                    {
                        System.out.print("Nhap ngay nhap hang hoa moi : ");
                        t.data.ngay=tt.nextInt();
                        System.out.println("Cap nhat ngay nhap hang hoa thanh cong ");
                        g=tt.nextLine();
                        g=tt.nextLine();
                        break;
                    }
                }
            }while(choice!=5);
            return;
        }
        if (t.data.ma.compareTo(ma)>0 && t.left!=null)  
            update(t.left, ma); 
        if(t.right!=null)
            update(t.right, ma);
    }
    void searchLoai(Node root1,String x)  
    { 
        if (root1.data.loai.compareTo(x)==0) 
        {
            k=true; 
            System.out.println(root1.data.toString());
        }
        if (root1.left!=null)  
            searchLoai(root1.left, x); 
        if(root1.right!=null)
            searchLoai(root1.right, x); 
    }
    void searchGia(Node root1,int x1,int x2)  
    { 
        if ((root1.data.giaNhap>=x1) && (root1.data.giaNhap<=x2)) 
        {
            k=true; 
            System.out.println(root1.data.toString());
        }
        if (root1.left!=null)  
            searchGia(root1.left, x1,x2); 
        if(root1.right!=null)
            searchGia(root1.right, x1,x2); 
    }
    void searchNgay(Node root1,int x1,int x2)  
    { 
        if ((root1.data.ngay>=x1) && (root1.data.ngay<=x2)) 
        {
            k=true; 
            System.out.println(root1.data.toString());
        }
        if (root1.left!=null)  
            searchNgay(root1.left, x1,x2); 
        if(root1.right!=null)
            searchNgay(root1.right, x1,x2); 
    }
    void addARR(ArrayList<DT> a,Node t)
    {
        if(t==null)
            return;
        if (t != null) 
        { 
            addARR(a,t.left); 
            a.add(t.data);
            addARR(a,t.right); 
        } 
    }
    void addLoai(ArrayList<String> a,Node t)
    {
        if(t==null)
            return;
        if (t != null) 
        { 
            addLoai(a,t.left); 
            int i;
            for(i=0;i<a.size();i++)
                if(a.get(i).compareTo(t.data.loai)==0)
                    break;
            if(i==a.size())
                a.add(t.data.loai);
            addLoai(a,t.right); 
        } 
    }
    int TongSoLuong(Node t)
    {
        if(t==null)
            return 0;
        return t.data.soLuong+TongSoLuong(t.left)+TongSoLuong(t.right);
    }
    int demLoaiHH(String x,Node t)
    {
        if(t==null)
            return 0;
        if(x.compareTo(t.data.loai)==0)
            return t.data.soLuong+demLoaiHH(x,t.left)+demLoaiHH(x,t.right);
            else
                return demLoaiHH(x,t.left)+demLoaiHH(x,t.right);
    }
    int TongGiaTri(Node t)
    {
        if(t==null)
            return 0;
        return t.data.soLuong*t.data.giaNhap+TongGiaTri(t.left)+TongGiaTri(t.right);
    }
    
    void xuly () 
    {  
        BinarySearchTree();
        int choice=0;
        DT tam=new DT("Dien thoai","DT01","Iphone 7",5000000,4,13);
        root=insertRec(root,tam);
        tam=new DT("Dien thoai","DT02","Iphone 7+",6000000,3,13);
        root=insertRec(root,tam);
        tam=new DT("Dien thoai","DT03","Iphone 7s",6500000,2,15);
        root=insertRec(root,tam);
        tam=new DT("Dien thoai","DT04","Iphone 6",5000000,4,13);
        root=insertRec(root,tam);
        tam=new DT("Dien thoai","DT05","Iphone 6s",6000000,7,17);
        root=insertRec(root,tam);
        tam=new DT("Dien thoai","DT06","Iphone 6+",6500000,1,13);
        root=insertRec(root,tam);
        tam=new DT("Dien thoai","DT07","Iphone 11",16000000,2,13);
        root=insertRec(root,tam);
        tam=new DT("Dien thoai","DT08","Iphone 11 Pro",17000000,3,14);
        root=insertRec(root,tam);
        tam=new DT("Dien thoai","DT09","Iphone X",13000000,4,8);
        root=insertRec(root,tam);
        tam=new DT("Dien thoai","DT11","Oppo A12",3000000,7,22);
        root=insertRec(root,tam);
        tam=new DT("Dien thoai","DT12","SamSung Galaxy s8",8000000,7,11);
        root=insertRec(root,tam);
        tam=new DT("Dien thoai","DT13","Oppo Neo7",2300000,9,14);
        root=insertRec(root,tam);
        tam=new DT("Dien thoai","DT14","Nokia 1028",200000,14,3);
        root=insertRec(root,tam);
        tam=new DT("Dien thoai","DT15","Vsmart",4000000,12,1);
        root=insertRec(root,tam);
        tam=new DT("Dien thoai","DT16","Vetur",800000000,1,14);
        root=insertRec(root,tam);
        tam=new DT("Laptop","LT01","Dell i7",21000000,2,25);
        root=insertRec(root,tam);
        tam=new DT("Laptop","LT02","Dell i9",31000000,3,2);
        root=insertRec(root,tam);
        tam=new DT("Laptop","LT03","Dell i5",15000000,5,3);
        root=insertRec(root,tam);
        tam=new DT("Laptop","LT04","Dell i3",11000000,6,17);
        root=insertRec(root,tam);
        tam=new DT("Laptop","LT05","Mac",41000000,2,8);
        root=insertRec(root,tam);
        tam=new DT("Laptop","LT05","HP",17000000,6,28);
        root=insertRec(root,tam);
        tam=new DT("Laptop","LT07","Asus",2400000,2,25);
        root=insertRec(root,tam);
        do
        {
            clearScreen(); 
            System.out.print("------------MENU------------\n1. Them, xoa, sua hang hoa\n2. Tim kiem hang hoa\n3. Sap xep hang hoa\n4. Thong ke\n5. Thoat\nHay chon : ");
            choice=tt.nextInt();
            switch(choice)
            {
                case 1:
                {
                    int choice1;
                    do
                    {
                        clearScreen(); 
                        System.out.print("------------MENU-1----------\n1. Them hang hoa\n2. Xoa hang hoa\n3. Sua hang hoa\n4. Quay ve menu chinh\nHay chon : ");
                        choice1=tt.nextInt();
                        switch(choice1)
                        {
                            case 1:
                            {
                                clearScreen(); 
                                themHangHoa();
                                break;
                            }
                            case 2:
                            {
                                clearScreen(); 
                                xoaHangHoa();
                                break;
                            }
                            case 3:
                            {
                                System.out.print("Nhap ma hang hoa can sua thong tin : ");
                                String ma;
                                tt.nextLine();
                                ma=tt.nextLine();
                                update(root,ma);
                                if(k==true)
                                    System.out.println("Sua thong tin thanh cong ");
                                       else System.out.println("Khong ton tai hang hoa co ma la "+ma);
                                k=false;
                                ma=tt.nextLine();
                                break;
                            }
                        }
                    }while(choice1!=4);
                    break;
                }
                case 2:
                {
                    int choice2;
                    do
                    {
                        clearScreen(); 
                        System.out.print("------------MENU-2----------\n1. Tim kiem theo loai\n2. Tim kiem theo khoang  gia\n3. Tim kiem theo khoang ngay nhap\n4. Quay ve menu chinh\nHay chon : ");
                        choice2=tt.nextInt();
                        switch(choice2)
                        {
                            case 1:
                            {
                                clearScreen();
                                System.out.print("Nhap loai hang hoa can tim : ");
                                String x=new String();
                                tt.nextLine();
                                x=tt.nextLine();
                                if(root!=null)
                                    searchLoai(root,x);
                                if(k==false)
                                    System.out.println("Khong co hang hoa co loai la "+x);
                                k=false;
                                x=tt.nextLine();
                                break;
                            }
                            case 2:
                            {
                                clearScreen();
                                System.out.println("Nhap khoan gia hang hoa can tim : ");
                                int x1,x2;
                                System.out.print("Nhap moc gia dau : ");
                                x1=tt.nextInt();
                                System.out.print("Nhap moc gia cuoi : ");
                                x2=tt.nextInt();
                                if(root!=null)
                                    searchGia(root,x1,x2);
                                if(k==false)
                                    System.out.println("Khong co hang hoa co gia trong khoang tu "+x1+"(vnd) den "+x2+"(vnd) !");
                                k=false;
                                String x;
                                x=tt.nextLine();
                                x=tt.nextLine();
                                break;
                            }
                            case 3:
                            {
                               clearScreen();
                                System.out.println("Nhap khoan gia hang hoa can tim : ");
                                int x1,x2;
                                System.out.print("Nhap moc ngay dau : ");
                                x1=tt.nextInt();
                                System.out.print("Nhap moc ngay cuoi : ");
                                x2=tt.nextInt();
                                if(root!=null)
                                    searchNgay(root,x1,x2);
                                if(k==false)
                                    System.out.println("Khong co hang hoa co ngay nhap trong khoang tu ngay "+x1+" den ngay "+x2+" !");
                                k=false;
                                String x;
                                x=tt.nextLine();
                                x=tt.nextLine();
                                break;
                            }
                        }
                    }while(choice2!=4);
                    break;
                }
                case 3:
                {
                    int choice3;
                    do
                    {
                        clearScreen(); 
                        ArrayList<DT> a=new ArrayList<DT>();
                        addARR(a,root);
                        System.out.print("------------MENU-3----------\n1. Sap xep giam dan theo gia\n2. Sap xep tang dan theo gia\n3. Sap xep giam dan theo ngay nhap\n4. Sap xep tang dan theo ngay nhap\n5. Quay ve menu chinh\nHay chon : ");
                        choice3=tt.nextInt();
                        switch(choice3)
                        {
                            case 1:
                            {
                                clearScreen();
                                for(int i=0;i<a.size()-1;i++)
                                    for(int j=i+1;j<a.size();j++)
                                        if(a.get(i).giaNhap<a.get(j).giaNhap)
                                        {
                                            DT tam1=a.get(i);
                                            a.set(i,a.get(j));
                                            a.set(j,tam1);
                                        }
                                for(int i=0;i<a.size();i++)
                                    System.out.println("Loai : "+a.get(i).loai+" ,Ma : "+a.get(i).ma+" ,Ten : "+a.get(i).ten+" , Gia nhap : "+a.get(i).giaNhap+" (vnd) , So luong : "+a.get(i).soLuong+" ,Ngay nhap : "+a.get(i).ngay); 
                                tt.nextLine();
                                String x;
                                x=tt.nextLine();
                                break;
                            }
                            case 2:
                            {
                                clearScreen();
                                for(int i=0;i<a.size()-1;i++)
                                    for(int j=i+1;j<a.size();j++)
                                        if(a.get(i).giaNhap>a.get(j).giaNhap)
                                        {
                                            DT tam1=a.get(i);
                                            a.set(i,a.get(j));
                                            a.set(j,tam1);
                                        }
                                for(int i=0;i<a.size();i++)
                                    System.out.println("Loai : "+a.get(i).loai+" ,Ma : "+a.get(i).ma+" ,Ten : "+a.get(i).ten+" , Gia nhap : "+a.get(i).giaNhap+" (vnd) , So luong : "+a.get(i).soLuong+" ,Ngay nhap : "+a.get(i).ngay);
                                tt.nextLine();
                                String x;
                                x=tt.nextLine();
                                break;
                            }
                            case 3:
                            {
                                clearScreen();
                                for(int i=0;i<a.size()-1;i++)
                                    for(int j=i+1;j<a.size();j++)
                                        if(a.get(i).ngay<a.get(j).ngay)
                                        {
                                            DT tam1=a.get(i);
                                            a.set(i,a.get(j));
                                            a.set(j,tam1);
                                        }
                                for(int i=0;i<a.size();i++)
                                    System.out.println("Loai : "+a.get(i).loai+" ,Ma : "+a.get(i).ma+" ,Ten : "+a.get(i).ten+" , Gia nhap : "+a.get(i).giaNhap+" (vnd) , So luong : "+a.get(i).soLuong+" ,Ngay nhap : "+a.get(i).ngay);
                                tt.nextLine();
                                String x;
                                x=tt.nextLine();
                                break;
                            }
                            case 4:
                            {
                                clearScreen();
                                for(int i=0;i<a.size()-1;i++)
                                    for(int j=i+1;j<a.size();j++)
                                        if(a.get(i).ngay>a.get(j).ngay)
                                        {
                                            DT tam1=a.get(i);
                                            a.set(i,a.get(j));
                                            a.set(j,tam1);
                                        }
                                for(int i=0;i<a.size();i++)
                                    System.out.println("Loai : "+a.get(i).loai+" ,Ma : "+a.get(i).ma+" ,Ten : "+a.get(i).ten+" , Gia nhap : "+a.get(i).giaNhap+" (vnd) , So luong : "+a.get(i).soLuong+" ,Ngay nhap : "+a.get(i).ngay); 
                                tt.nextLine();
                                String x;
                                x=tt.nextLine();
                                break;
                            }
                        }
                    }while(choice3!=5);
                    break;
                }
                case 4:
                {
                    int choice4;
                    do
                    {
                        clearScreen(); 
                        System.out.print("------------MENU-4----------\n1. Thong ke tong so luong hang hoa\n2. Thong ke tong gia tri nhap kho\n3. Thong ke so luong tung loai hang\n4. Quay ve menu chinh\nHay chon : ");
                        choice4=tt.nextInt();
                        switch(choice4)
                        {
                            case 1:
                            {
                                clearScreen(); 
                                System.out.println("Tong so luong hang hoa : "+TongSoLuong(root));
                                tt.nextLine();
                                String x;
                                x=tt.nextLine();
                                break;
                            }
                            case 2:
                            {
                                clearScreen();
                                System.out.println("Tong gia tri nhap kho la "+TongGiaTri(root)+"(vnd)");
                                tt.nextLine();
                                String x;
                                x=tt.nextLine(); 
                                break;
                            }
                            case 3:
                            {
                                clearScreen();
                                ArrayList<String> a=new ArrayList<String>();
                                addLoai(a,root);
                                for(int i=0;i<a.size();i++)
                                    System.out.println("Tong so luong hang hoa loai "+a.get(i)+" la : "+demLoaiHH(a.get(i),root));
                                tt.nextLine();
                                String x;
                                x=tt.nextLine(); 
                                break;
                            }
                        }
                    }while(choice4!=4);
                    break;
                }
            }
        }while(choice!=5);
    } 
    public static void main (String arg[]) 
    {  
        main a=new main();
        a.xuly();
    }    
}