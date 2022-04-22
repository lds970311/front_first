import React, {Component} from 'react';
import PropTypes from 'prop-types';
import axios from "axios";
import "../../styles/movie.css"

class Center extends Component {
    componentDidMount() {
        this.getMovieData()
    }

    state = {
        movieList: [],
        detail: ""
    }

    handleEvent(data) {
        this.setState({
            detail: data
        })
    }

    render() {
        const {title} = this.props;
        return (
            <div>
                <h3 style={{textAlign: 'center'}}>{title}</h3>
                {this.state.movieList.map(item => {
                    return (
                        <MovieItem key={item.filmId} {...item}
                                   onEvent={detail => this.handleEvent(detail)}/>
                    )
                })}}
                <MovieDetail detail={this.state.detail}/>
            </div>
        );
    }

    getMovieData() {
        axios.get("/movie.json")
            .then(response => {
                this.setState({
                    movieList: response.data.data.films
                })
            })
    }
}

Center.propTypes = {
    title: PropTypes.string.isRequired
};


class MovieItem extends Component {
    render() {
        // console.log(this.props)
        let {name, poster, grade, synopsis, nation, director, category} = this.props;
        return (
            <div
                className="filmItem"
                onClick={() => {
                    // console.log(synopsis)
                    this.props.onEvent(synopsis);
                }}
            >
                <img src={poster} alt={name}/>
                <h4>{name}</h4>
                <p>类别: {category}</p>
                <p>地区: {nation}</p>
                <div>观众评分：{grade}</div>
                <p>导演: {director}</p>
            </div>
        );
    }
}


class MovieDetail extends Component {
    render() {
        return (
            <div>
                <div className="filmDetail">{this.props.detail}</div>
                ;
            </div>
        );
    }
}


export default Center;
