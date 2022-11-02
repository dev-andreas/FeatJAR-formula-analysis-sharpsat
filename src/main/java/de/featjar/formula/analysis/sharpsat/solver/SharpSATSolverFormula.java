/*
 * Copyright (C) 2022 Sebastian Krieter
 *
 * This file is part of formula-analysis-sharpsat.
 *
 * formula-analysis-sharpsat is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3.0 of the License,
 * or (at your option) any later version.
 *
 * formula-analysis-sharpsat is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with formula-analysis-sharpsat. If not, see <https://www.gnu.org/licenses/>.
 *
 * See <https://github.com/FeatureIDE/FeatJAR-formula-analysis-sharpsat> for further information.
 */
package de.featjar.formula.analysis.sharpsat.solver;

import de.featjar.formula.analysis.solver.SolverFormula;
import de.featjar.formula.analysis.solver.SolverContradictionException;
import de.featjar.formula.clauses.*;
import de.featjar.formula.structure.formula.Formula;
import java.util.List;

/**
 * Formula for {@link SharpSATSolver}.
 *
 * @author Sebastian Krieter
 */
public class SharpSATSolverFormula extends SolverFormula<LiteralList> {
    VariableMap variableMap;

    public SharpSATSolverFormula() {
        super();
    }

    @Override
    public List<LiteralList> push(Formula expression) throws SolverContradictionException {
        //final ClauseList clauses = ToCNF.convert(expression, termMap).getClauses();
        final ClauseList clauses = ToCNF.convert(expression).get().getClauses();
        this.solverFormulas.addAll(clauses);
        variableMap = VariableMap.of(expression);
        return clauses;
    }

    public List<LiteralList> push(CNF cnf) throws SolverContradictionException {
        this.solverFormulas.addAll(cnf.getClauses());
        return cnf.getClauses();
    }

    @Override
    public void clear() {
        solverFormulas.clear();
    }

    public CNF getCNF() {
        //return new CNF(termMap, solverFormulas);
        return new CNF(variableMap, solverFormulas);
    }
}