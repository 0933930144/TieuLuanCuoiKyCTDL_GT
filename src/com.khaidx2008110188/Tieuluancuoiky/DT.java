package DuongXuanKhai;
public class DT {

    public
        String loai;
        String ma;
        String ten;
        int giaNhap;
        int soLuong;
        int ngay;
    public DT(String loai, String ma, String ten, int giaNhap,int soLuong,int ngay)
    {
        this.loai = loai;
        this.ma = ma;
        this.ten = ten;
        this.giaNhap = giaNhap;
        this.soLuong=soLuong;
        this.ngay=ngay;
    }
    public String toString()
    {
        return "Loai: "+loai+", Ma : "+ma+", Ten : "+ten+",Gia nhap : "+giaNhap+"(vnd), SoLuong : "+soLuong+", Ngay nhap : "+ngay;
    }
}
