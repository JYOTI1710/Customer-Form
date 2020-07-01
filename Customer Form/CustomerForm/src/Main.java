/**
 * Created by Personal on 25-12-2017.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class Main
{
    public static void main(String[] args)
    {
        Cus c=new Cus();
    }
}

class Cus
{
    Cus( )
    {

        JFrame main = new JFrame( "AIR CONDITIONING SALES AND SERVICES" );
        main.setSize( 500, 400 );
        main.setBackground( Color.GRAY );
        JButton custF = new JButton( "CUSTOMER FORM" );
        custF.setBounds( 150, 50, 180, 50 );
        main.add( custF );
        custF.addActionListener( new ActionListener( )
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerForm( );
            }
        } );
        JButton custH = new JButton( "CUSTOMER HISTORY" );
        custH.setBounds( 150, 150, 180, 50 );
        main.add( custH );
        custH.addActionListener( new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerHistory( );
            }
        } );
        JButton sch = new JButton( "SCHEDULE" );
        sch.setBounds( 150, 250, 180, 50 );
        main.add( sch );
        sch.addActionListener( new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                schedule( );
            }
        } );
        main.setLayout( null );
        main.setVisible( true );
        main.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }

    public void customerForm( )
    {
        JLabel nme, phn, add, mail, mod, feed, sym, state, pc, id;
        JTextField tname, tphn, tadd, tmail, tmod, tmess, tstate, tpc, tid;
        JButton submit;

        //FRAME
        JFrame f = new JFrame( "Customer Form" );

        //LABEL
        id = new JLabel( "Customer ID" );
        id.setBounds( 150, 5, 100, 50 );
        id.setFont( new Font( "Courier", Font.PLAIN, 12 ) );

        nme = new JLabel( "Full Name" );
        nme.setBounds( 150, 55, 100, 50 );
        nme.setFont( new Font( "Courier", Font.PLAIN, 12 ) );

        phn = new JLabel( "Contact No." );
        phn.setBounds( 150, 105, 100, 50 );
        phn.setFont( new Font( "Courier", Font.PLAIN, 12 ) );

        mail = new JLabel( "Email ID" );
        mail.setBounds( 150, 155, 100, 50 );
        mail.setFont( new Font( "Courier", Font.PLAIN, 12 ) );

        add = new JLabel( "Full Address" );
        add.setBounds( 150, 205, 100, 50 );
        add.setFont( new Font( "Courier", Font.PLAIN, 12 ) );

        state = new JLabel( "State" );
        state.setBounds( 150, 255, 100, 50 );
        state.setFont( new Font( "Courier", Font.PLAIN, 12 ) );

        pc = new JLabel( "Pin Code" );
        pc.setBounds( 500, 255, 100, 50 );
        pc.setFont( new Font( "Courier", Font.PLAIN, 12 ) );

        mod = new JLabel( "AC Model" );
        mod.setBounds( 150, 305, 100, 50 );
        mod.setFont( new Font( "Courier", Font.PLAIN, 12 ) );

        sym = new JLabel( "Problems" );
        sym.setBounds( 150, 355, 100, 50 );
        sym.setFont( new Font( "Courier", Font.PLAIN, 12 ) );

        feed = new JLabel( "Feedback" );
        feed.setBounds( 150, 555, 100, 50 );
        feed.setFont( new Font( "Courier", Font.PLAIN, 12 ) );

        //CHECKBOX
        JCheckBox nw = new JCheckBox( "Not Working" );
        nw.setBounds( 250, 355, 200, 20 );
        f.add( nw );

        JCheckBox nc = new JCheckBox( "Not Cold" );
        nc.setBounds( 500, 355, 200, 20 );
        f.add( nc );

        JCheckBox tc = new JCheckBox( "Trunking condensation" );
        tc.setBounds( 250, 385, 200, 20 );
        f.add( tc );

        JCheckBox gl = new JCheckBox( "Gas leaking" );
        gl.setBounds( 500, 385, 200, 20 );
        f.add( gl );

        JCheckBox n = new JCheckBox( "Noisy" );
        n.setBounds( 250, 415, 200, 20 );
        f.add( n );

        JCheckBox hvnw = new JCheckBox( "Horizontal vane not working" );
        hvnw.setBounds( 500, 415, 200, 20 );
        f.add( hvnw );

        JCheckBox wl = new JCheckBox( "Water leaking" );
        wl.setBounds( 250, 445, 200, 20 );
        f.add( wl );

        JCheckBox gs = new JCheckBox( "General servicing" );
        gs.setBounds( 500, 445, 200, 20 );
        f.add( gs );

        JCheckBox rcnd = new JCheckBox( "Remote control no display" );
        rcnd.setBounds( 250, 475, 200, 20 );
        f.add( rcnd );

        JCheckBox rcnw = new JCheckBox( "Remote control not working" );
        rcnw.setBounds( 500, 475, 200, 20 );
        f.add( rcnw );

        JCheckBox o = new JCheckBox( "Others" );
        o.setBounds( 250, 505, 100, 20 );
        f.add( o );

        f.add( id );
        f.add( nme );
        f.add( phn );
        f.add( mail );
        f.add( add );
        f.add( mod );
        f.add( sym );
        f.add( feed );
        f.add( state );
        f.add( pc );

        //TEXTFIELD
        tid = new JTextField( );
        tid.setBounds( 250, 5, 700, 40 );
        tname = new JTextField( );
        tname.setBounds( 250, 55, 700, 40 );
        tphn = new JTextField( );
        tphn.setBounds( 250, 105, 700, 40 );
        tmail = new JTextField( 100 );
        tmail.setBounds( 250, 155, 700, 40 );
        tadd = new JTextField( );
        tadd.setBounds( 250, 205, 700, 40 );
        tstate = new JTextField( );
        tstate.setBounds( 250, 255, 200, 40 );
        tpc = new JTextField( );
        tpc.setBounds( 580, 255, 200, 40 );
        tmod = new JTextField( );
        tmod.setBounds( 250, 305, 700, 40 );
        tmess = new JTextField( 500 );
        tmess.setBounds( 250, 555, 700, 50 );

        f.add( tid );
        f.add( tname );
        f.add( tphn );
        f.add( tadd );
        f.add( tmail );
        f.add( tmod );
        f.add( tmess );
        f.add( tstate );
        f.add( tpc );
        f.setBackground( Color.lightGray );
        f.setSize( 1600, 2200 );
        f.setLayout( null );
        f.setVisible( true );
        f.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        //SUBMIT
        submit = new JButton( "SUBMIT" );
        submit.setBounds( 500, 620, 150, 50 );
        f.add( submit );

        submit.addActionListener( new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mysql?verifyServerCertificate=false&useSSL=true", "root", "root" );
                    String dnw = null;
                    String dnc = null;
                    String dtc = null;
                    String dgl = null;
                    String dn = null;
                    String dhvnw = null;
                    String dwl = null;
                    String dgs = null;
                    String drcnd = null;
                    String drcnw = null;
                    String dot = null;

                    if (nw.isSelected( )) {
                        dnw = "YES";
                    } else {
                        dnw = "NO";
                    }

                    if (nc.isSelected( )) {
                        dnc = "YES";
                    } else {
                        dnc = "NO";
                    }

                    if (tc.isSelected( )) {
                        dtc = "YES";
                    } else {
                        dtc = "NO";
                    }

                    if (gl.isSelected( )) {
                        dgl = "YES";
                    } else {
                        dgl = "NO";
                    }

                    if (n.isSelected( )) {
                        dn = "YES";
                    } else {
                        dn = "NO";
                    }

                    if (hvnw.isSelected( )) {
                        dhvnw = "YES";
                    } else {
                        dhvnw = "NO";
                    }

                    if (wl.isSelected( )) {
                        dwl = "YES";
                    } else {
                        dwl = "NO";
                    }

                    if (gs.isSelected( )) {
                        dgs = "YES";
                    } else {
                        dgs = "NO";
                    }

                    if (rcnd.isSelected( )) {
                        drcnd = "YES";
                    } else {
                        drcnd = "NO";
                    }

                    if (rcnw.isSelected( )) {
                        drcnw = "YES";
                    } else {
                        drcnw = "NO";
                    }

                    if (o.isSelected( )) {
                        dot = "YES";
                    } else {
                        dot = "NO";
                    }

                    DateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" );
                    java.util.Date date = new java.util.Date( );
                    Statement st = con.createStatement( );
                    String rs = "INSERT INTO mysql57.customer  (DATE_TIME,C_ID,Full_Name,Contact_no,Email_ID,Full_Address,State,Pin_Code,AC_Model,Not_Working,Not_Cold,Trunking_condensation,Gas_leaking,Noisy,Horizontal_vane_not_working,water_leaking,General_servicing,Remote_control_no_display,Remote_control_not_working,Other,Message) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement( rs );
                    preparedStatement.setString( 1, dateFormat.format( date ) );
                    preparedStatement.setString( 2, tid.getText( ) );
                    preparedStatement.setString( 3, tname.getText( ) );
                    preparedStatement.setString( 4, tphn.getText( ) );
                    preparedStatement.setString( 5, tmail.getText( ) );
                    preparedStatement.setString( 6, tadd.getText( ) );
                    preparedStatement.setString( 7, tstate.getText( ) );
                    preparedStatement.setString( 8, tpc.getText( ) );
                    preparedStatement.setString( 9, tmod.getText( ) );
                    preparedStatement.setString( 10, dnw );
                    preparedStatement.setString( 11, dnc );
                    preparedStatement.setString( 12, dtc );
                    preparedStatement.setString( 13, dgl );
                    preparedStatement.setString( 14, dn );
                    preparedStatement.setString( 15, dhvnw );
                    preparedStatement.setString( 16, dwl );
                    preparedStatement.setString( 17, dgs );
                    preparedStatement.setString( 18, drcnd );
                    preparedStatement.setString( 19, drcnw );
                    preparedStatement.setString( 20, dot );
                    preparedStatement.setString( 21, tmess.getText( ) );
                    preparedStatement.executeUpdate( );

                    JOptionPane.showMessageDialog( f, "SUBMITTED.......WE WILL VISIT YOU BY TOMMORROW" );
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog( f, ex );
                }
            }
        } );
    }

    public void customerHistory( ) {
        JFrame f = new JFrame( "CUSTOMER HISTORY" );
        JLabel ID = new JLabel( "CUSTOMER ID" );
        ID.setBounds( 50, 150, 100, 50 );
        f.add( ID );
        JTextField TID = new JTextField( );
        TID.setBounds( 200, 150, 100, 50 );
        f.add( TID );
       JButton B = new JButton( "ENTER" );
        B.setBounds( 250, 250, 100, 50 );
        f.add( B );
        f.setLayout( null );
        f.setSize( 500,500 );
        f.setVisible( true );
        f.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        B.addActionListener( new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TID.getText().isEmpty()){
                    JOptionPane.showMessageDialog( f,"ENTER CUSTOMER ID" );
                }
                else {
                    findId( TID.getText( ) );
                }
            }
    } );
    }

    public void findId(String S){
        JFrame f1 = new JFrame( );
        f1.setVisible( true );
        try
        {
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mysql?verifyServerCertificate=false&useSSL=true", "root", "root" );
            String sql = "SELECT * FROM mysql57.customer where C_ID =" +S;
            Statement st = con.createStatement( );
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement( sql );
            ResultSet rs = st.executeQuery( sql );
            boolean empty = true;
            while (rs.next( )) {
                empty = false;
            }
            if (empty) {
                JOptionPane.showMessageDialog( f1, "ID NOT FOUND IN DATABASE" );
                f1.setVisible( false );
            }
            else {
                idFound( S );
            }}
        catch (SQLException e)
        {
            System.out.println( e );
        }
        f1.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }

    public void idFound(String S){
        JFrame  f2 = new JFrame("CUSTOMER HISTORY" );
        f2.setVisible( true );
        Vector columnNames = new Vector();
        Vector data = new Vector();
        try
        {
            String s= S;
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mysql?verifyServerCertificate=false&useSSL=true", "root", "root" );
            String sql = "SELECT * FROM mysql57.customer where C_ID =" +s;
            Statement st = con.createStatement( );
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement( sql );
            ResultSet rs = st.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( md.getColumnName(i) );
            }
            while (rs.next())
            {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++)
                {
                    row.addElement(rs.getObject(i));
                }
                data.addElement(row);
            }
            rs.close();
            st.close();
        }
        catch (SQLException e)
        {
            System.out.println( e );
        }
        JTable table = new JTable( data, columnNames );
        JScrollPane scrollPane = new JScrollPane( table );
        f2.add( scrollPane );
        f2.pack( );
        f2.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }

    public void schedule( )
    {
        JFrame f = new JFrame( );
        f.setVisible( true );
        Vector columnNames = new Vector();
        Vector data = new Vector();
        try
        {
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mysql?verifyServerCertificate=false&useSSL=true", "root", "root" );
            String sql = "SELECT * FROM mysql57.customer order BY DATE_TIME ASC";
            Statement st = con.createStatement( );
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement( sql );
            ResultSet rs = st.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( md.getColumnName(i) );
            }
            while (rs.next())
            {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++)
                {
                    row.addElement(rs.getObject(i));
                }
                data.addElement(row);
            }
            rs.close();
            st.close();
        }
        catch (SQLException e)
        {
            System.out.println( e );
        }
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane( table );
        f.add( scrollPane );
        f.pack();
        f.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }

}






