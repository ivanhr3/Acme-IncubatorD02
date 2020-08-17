
package acme.entities.creditCards;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CreditCard extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				holderName;

	@NotBlank
	@CreditCardNumber
	private Integer				number;

	@NotBlank
	private String				brand;

	@NotBlank
	@Pattern(regexp = "[0-9]{2}/[0-9]{2}")
	private String				expires;

	@NotBlank
	@Pattern(regexp = "[0-9]{3}")
	private String				CVV;

}
