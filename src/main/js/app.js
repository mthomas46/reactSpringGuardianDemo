//'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
import {Button} from 'react-bootstrap'


class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {guardians: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/guardians'}).done(response => {
			this.setState({guardians: response.entity._embedded.guardians});
		});
	}

	render() {
		return (
		    <>
			    <GuardianList guardians={this.state.guardians}/>
			    <Button variant="primary">Primary</Button>{' '}
			</>
		)
	}
}

class GuardianList extends React.Component{
	render() {
		const guardians = this.props.guardians.map(guardian =>
			<Guardian key={guardian._links.self.href} guardian={guardian}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>displayName</th>
						<th>membershipId</th>
					</tr>
					{guardians}
				</tbody>
			</table>
		)
	}
}

class Guardian extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.guardian.displayName}</td>
				<td>{this.props.guardian.membershipId}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)