package com.example.william.mapas.Bancos;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by william on 29/03/2016.
 */
public class ManipulacaoBancos {
    public String resultado;

    public void salvarTabConfig(Context context,
                                String ativo,
                                String local,
                                String horario,
                                String obs){

        BancoControllerConfig bancoControllerConfig = new BancoControllerConfig(context);

        resultado = bancoControllerConfig.insereDado(ativo, horario, local, obs);

        Toast.makeText(context, "\t\t\t\t\tNova Contagem:\n "+resultado, Toast.LENGTH_SHORT).show();
    }

    public void salvarTabFaltas(Context context,
                                int id2,
                                String dom,
                                String seg,
                                String ter,
                                String qua,
                                String qui,
                                String sex,
                                String sab,
                                String data,
                                String local1,
                                String local2,
                                String obs){

        BancoControllerFaltas bancoController = new BancoControllerFaltas(context);

        resultado = bancoController.insereDado(id2, dom, seg, ter, qua, qui, sex, sab, data, local1, local2, obs);
        Toast.makeText(context, "\t\t\t\t\t\tNova Falta:\n"+resultado, Toast.LENGTH_SHORT).show();
    }

}
