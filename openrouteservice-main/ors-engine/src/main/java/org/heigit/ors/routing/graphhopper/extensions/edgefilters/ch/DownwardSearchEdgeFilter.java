/*  This file is part of Openrouteservice.
 *
 *  Openrouteservice is free software; you can redistribute it and/or modify it under the terms of the
 *  GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1
 *  of the License, or (at your option) any later version.

 *  This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU Lesser General Public License for more details.

 *  You should have received a copy of the GNU Lesser General Public License along with this library;
 *  if not, see <https://www.gnu.org/licenses/>.
 */
package org.heigit.ors.routing.graphhopper.extensions.edgefilters.ch;

import com.graphhopper.storage.RoutingCHEdgeIteratorState;
import com.graphhopper.storage.RoutingCHGraph;

public class DownwardSearchEdgeFilter extends CHLevelEdgeFilter {

    public DownwardSearchEdgeFilter(RoutingCHGraph g) {
        super(g);
    }

    @Override
    public boolean accept(RoutingCHEdgeIteratorState edgeIterState) {
        return accept(edgeIterState, false);
    }

    public boolean accept(RoutingCHEdgeIteratorState edgeIterState, boolean swap) {
        int adj = edgeIterState.getAdjNode();

        if (baseNode >= maxNodes || adj >= maxNodes || baseNodeLevel <= graph.getLevel(adj))
            return isAccessible(edgeIterState, !swap);
        else
            return false;
    }
}
