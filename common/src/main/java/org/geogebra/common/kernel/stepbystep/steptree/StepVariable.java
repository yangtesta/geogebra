package org.geogebra.common.kernel.stepbystep.steptree;

import org.geogebra.common.plugin.Operation;

public class StepVariable extends StepNode {
	private String label;

	public StepVariable(String label) {
		this.label = label;
	}

	@Override
	public boolean equals(StepNode sn) {
		return sn.toString().equals(label);
	}

	@Override
	public boolean isOperation() {
		return false;
	}

	@Override
	public boolean isOperation(Operation op) {
		return false;
	}

	@Override
	public boolean isConstant() {
		return false;
	}

	@Override
	public int getPriority() {
		return 5;
	}

	@Override
	public double getValue() {
		return Double.NaN;
	}

	@Override
	public double getValueAt(StepNode variable, double replaceWith) {
		if (equals(variable)) {
			return replaceWith;
		}
		return Double.NaN;
	}

	@Override
	public StepConstant getConstantCoefficient() {
		return new StepConstant(1);
	}

	@Override
	public StepNode getCoefficient() {
		return null;
	}

	@Override
	public StepNode getVariable() {
		return this;
	}

	@Override
	public String toString() {
		return label;
	}

	@Override
	public String toLaTeXString() {
		return label;
	}

	@Override
	public StepNode deepCopy() {
		return new StepVariable(label);
	}

	@Override
	public StepNode regroup() {
		return this;
	}

	@Override
	public StepNode expand(Boolean[] changed) {
		return this;
	}

	@Override
	public StepNode simplify() {
		return this;
	}

	@Override
	public StepNode divideAndSimplify(double x) {
		return this;
	}

	@Override
	public boolean canBeEvaluated() {
		return false;
	}
}
