package dev.zeyuchen.banking_app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import dev.zeyuchen.banking_app.dto.AccountDto;
import dev.zeyuchen.banking_app.entity.Account;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDto toDto(Account account);

    Account toEntity(AccountDto accountDto);
}
