package apoio;

import java.math.BigDecimal;

public class DinheiroUtil {

    /**
     * <p>
     * Este método retornar um array de BigDecimal com tamanho igual a
     * quantidade de parcelas. Na primeira parcela é adicionado 0,01 como forma
     * de arredondar. Em testes feitos, este arredondamento se mostrou coerente
     * e satisfatório.</p>
     * <p>
     * <b> Ex: 100 / 3 = 33.3333333334….. </br>
     * É gerada uma parcela de valor 33.34 e as outras parcelas no valor de
     * 33.33</b>
     * </p>
     *
     * @param total
     * @param quantidadeParcelas
     * @return
     */
    
    public static BigDecimal[] totalParcelas(BigDecimal total, Integer quantidadeParcelas) {
        BigDecimal[] parcelas = null;

        if (total.equals(BigDecimal.ZERO)) {

            parcelas = new BigDecimal[1];
            parcelas[0] = BigDecimal.ZERO;

        } else {

            parcelas = new BigDecimal[quantidadeParcelas];

            BigDecimal valorInteiroDaDivisao = total.divideToIntegralValue(new BigDecimal(quantidadeParcelas));
            BigDecimal restoDaDivisao = verificaSeENegativoSeForTornaPositivo(total, quantidadeParcelas);
            Double restoDaDivisaoDivido = restoDaDivisao.doubleValue() / quantidadeParcelas;
            BigDecimal restoDivido = transformaRestoEmStringECriaBigDecimal(restoDaDivisaoDivido);

            if (restoDivido.equals(BigDecimal.ZERO)) {
                parcelas[0] = valorInteiroDaDivisao.add(valorInteiroDaDivisao.signum() == -1 ? restoDivido.negate() : restoDivido);
            } else {
                BigDecimal resto = restoDivido.add(new BigDecimal("0.01"));
            parcelas[0] = valorInteiroDaDivisao.add(valorInteiroDaDivisao.signum() == -1 ? resto.negate() : resto);
            }

            for (int i = 1; i < parcelas.length; i++) {
                parcelas[i] = valorInteiroDaDivisao.add(valorInteiroDaDivisao.signum() == -1 ? restoDivido.negate() : restoDivido);
            }
        }

        return parcelas;
    }

    private static BigDecimal verificaSeENegativoSeForTornaPositivo(BigDecimal total,
            Integer quantidadeParcelas) {
        BigDecimal restoDivisao = total.remainder(new BigDecimal(quantidadeParcelas));

        if (total.signum() == -1) {
            return restoDivisao.negate();
        }
        return restoDivisao;
    }

    private static BigDecimal transformaRestoEmStringECriaBigDecimal(Double restoDaDivisaoDivido) {
        if (!restoDaDivisaoDivido.equals(0.0)) {
            String restoDividoEmLiteral = restoDaDivisaoDivido.toString();
            String inteiro = restoDividoEmLiteral.substring(0, restoDividoEmLiteral.indexOf("."));
            String decimal = restoDividoEmLiteral.substring(restoDividoEmLiteral.indexOf("."), 4);
            BigDecimal restoDivido = new BigDecimal(inteiro + decimal);
            return restoDivido;
        }

        return BigDecimal.ZERO;
    }

}