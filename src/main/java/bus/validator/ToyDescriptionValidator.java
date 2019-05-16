/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.StringValidator;

/**
 *
 * @author CMQ
 */
public class ToyDescriptionValidator extends StringValidator {

    public ToyDescriptionValidator() {
        super("Mô tả đồ chơi", Integer.MAX_VALUE, StringValidator.LimitComparisonType.LessThanOrEqual, false, false, false);
    }
}
