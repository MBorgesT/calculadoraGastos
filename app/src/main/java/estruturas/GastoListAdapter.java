package estruturas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.matheus.calculadoragastos.R;
import java.util.ArrayList;


public class GastoListAdapter extends BaseAdapter {

    private static final String TAG = "GastoListAdapter";
    private final ArrayList<Gasto> gastos;
    private final Activity act;

    private Context mContext;
    int mResource;

    public GastoListAdapter(ArrayList<Gasto> gastos, Activity act) {
        this.gastos = gastos;
        this.act = act;
    }

    @Override
    public int getCount() {
        return this.gastos.size();
    }

    @Override
    public Object getItem(int position) {
        return gastos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.adapter_view_layout, parent, false);

        Gasto gasto = this.gastos.get(position);

        TextView textoProduto = (TextView) view.findViewById(R.id.textoProduto);
        TextView textoCategoria = (TextView) view.findViewById(R.id.textoCategoria);
        TextView textoValor = (TextView) view.findViewById(R.id.textoValor);
        ImageView imagemCategoria = (ImageView) view.findViewById(R.id.imagemCategoria);

        textoProduto.setText(gasto.getProduto());
        textoCategoria.setText(gasto.getCategoria().getNomeCategoria());
        textoValor.setText("R$ " + String.format("%.2f", gasto.getValor()));
        imagemCategoria.setBackgroundColor(gasto.getCategoria().getCor());

        return view;
    }
}
