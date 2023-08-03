package com.folksdev.account.dto;

import com.folksdev.account.model.Account;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {

    private final TransactionDtoConverter converter;

    public CustomerAccountDtoConverter(TransactionDtoConverter transactionDtoConverter) {
        this.converter = transactionDtoConverter;
    }

    public CustomerAccountDto convert(Account from) {
        return new CustomerAccountDto(Objects.requireNonNull(from.getId()),
                from.getBalance(),
                from.getTransaction().stream().map(converter::convert).collect(Collectors.toSet()),
                from.getCreationDate());
    }
}
