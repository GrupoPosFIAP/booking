package br.com.fiap.booking.repository.mapper;

import br.com.fiap.booking.domain.Predio;
import br.com.fiap.booking.domain.dto.QuartoReservaDto;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class QuartoReservaRowMapper implements RowMapper<QuartoReservaDto> {

    @Override
    public QuartoReservaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        QuartoReservaDto quartoReservaDto = new QuartoReservaDto();
        quartoReservaDto.setIdQuarto(rs.getString("id"));
        quartoReservaDto.setNome(rs.getString("nome"));
        quartoReservaDto.setDescricao(rs.getString("descricao"));
        quartoReservaDto.setTipo(rs.getString("tipo"));
        quartoReservaDto.setTotalPessoas(rs.getInt("total_pessoas"));
        quartoReservaDto.setQuantidadeCamas(rs.getInt("quantidade_camas"));
        quartoReservaDto.setMoveis(Arrays.asList(rs.getString("moveis").split(",")));
        quartoReservaDto.setValue(rs.getBigDecimal("value"));
        quartoReservaDto.setQuantidadeBanheiros(rs.getInt("quantidade_banheiros"));
        quartoReservaDto.setQuantidadeQuartos(rs.getInt("quantidade_quartos"));
        quartoReservaDto.setQuantidadeReservas(rs.getLong("quantidade_reservas"));
        return quartoReservaDto;
    }

}
