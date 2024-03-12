package br.com.fiap.booking.repository.custom;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Repository
public class ReservaCustomRepository {


    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ReservaCustomRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Map<String, Object>> consultarQuartosLivres(Long quartoId) {
        String SELECT_BY_ID = """
            select
                q.id ,
                q.predio_id ,
                q.nome ,
                q.tipo,\s
                array_to_string(array_agg(qm.moveis), ',') as moveis,
                q.quantidade_banheiros,
                q.quantidade_camas ,
                q.quantidade_quartos ,
                q.total_pessoas ,
                q.value ,
                q.descricao,
                r.quantidade_reservas
            from
                quarto_moveis qm,
                quarto q
            left outer join
                (
                select
                    r.quarto_id,
                    count(*) as quantidade_reservas
                from
                    reserva r
                where
                    r.data_inicial between symmetric :dataInicial and :dataFinal
                    or
                r.data_final between symmetric :dataInicial and :dataFinal
                    or\s
                (r.data_inicial <= :dataInicial
                        and r.data_final >= :dataInicial)
            group by
                r.quarto_id) r on
                r.quarto_id = q.id
            where
                qm.quarto_id = q.id
            group by 
                q.id, r.quantidade_reservas
             ;
                """;

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("dataInicial", Date.valueOf("2024-03-24"));
        paramSource.addValue("dataFinal", Date.valueOf("2024-03-27"));

        return namedParameterJdbcTemplate.queryForList(
                SELECT_BY_ID, paramSource);
    }

}
