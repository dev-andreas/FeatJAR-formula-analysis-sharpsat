/* -----------------------------------------------------------------------------
 * Formula-Analysis-SharpSat Lib - Library to analyze propositional formulas with SharpSAT.
 * Copyright (C) 2021  Sebastian Krieter
 * 
 * This file is part of Formula-Analysis-SharpSat Lib.
 * 
 * Formula-Analysis-SharpSat Lib is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 * 
 * Formula-Analysis-SharpSat Lib is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Formula-Analysis-SharpSat Lib.  If not, see <https://www.gnu.org/licenses/>.
 * 
 * See <https://github.com/skrieter/formula-analysis-sharpsat> for further information.
 * -----------------------------------------------------------------------------
 */
package org.spldev.analysis.sharpsat;

import org.spldev.analysis.sharpsat.solver.*;
import org.spldev.analysis.solver.SatSolver.*;
import org.spldev.util.data.*;
import org.spldev.util.job.*;

/**
 * Counts the number of valid solutions to a formula.
 * 
 * @author Sebastian Krieter
 */
public class HasSolutionsAnalysis extends SharpSatSolverAnalysis<SatResult> {

	public static final Identifier<SatResult> identifier = new Identifier<>();

	@Override
	public Identifier<SatResult> getIdentifier() {
		return identifier;
	}

	@Override
	protected SatResult analyze(SharpSatSolver solver, InternalMonitor monitor) throws Exception {
		return solver.hasSolution();
	}

}