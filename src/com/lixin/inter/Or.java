package com.lixin.inter;

import com.lixin.lexer.Token;

/**
 * @author lixin
 */
public class Or extends Logical {
    public Or(Token token, ExpressionNode node1, ExpressionNode node2) {
        super(token, node1, node2);
    }

    @Override
    public void jumping(int positive, int negative) {
        int label = positive != 0 ? positive : newLabel();
        node1.jumping(label, 0);
        node2.jumping(positive, negative);
        if (positive == 0) {
            emitLabel(label);
        }
    }
}
