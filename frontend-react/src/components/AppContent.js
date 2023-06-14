import * as React from "react";
import { ToastContainer, toast } from "react-toastify";
import { callApi } from "../helpers/axios_helper";
import { getUser, login, logout } from "../helpers/auth_helper";
import AuthContent from "./AuthContent";
import Buttons from "./Buttons";
import {
  MDBBtn,
  MDBCard,
  MDBCardBody,
  MDBCol,
  MDBContainer,
  MDBRow,
  MDBIcon,
  MDBInput,
  MDBTypography,
  MDBCardText,
} from "mdb-react-ui-kit";

export default class AppContent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      user: {},
      api: "",
      articles: [],
      comments: [],
    };
    this.shouldCancel = false;
  }

  componentDidMount() {
    this.getUser();
    this.fetchAllArticles();
  }

  componentWillUnmount() {
    this.shouldCancel = true;
  }

  login = () => {
    login();
  };

  callApi = () => {
    callApi()
        .then((response) => {
          this.setState({ api: response.data });
          toast.success("Api returned data successfully. Check in the Api response section.");
        })
        .catch((error) => {
          toast.error(error);
        });
  };

  logout = () => {
    logout();
  };

  getUser = () => {
    getUser().then((user) => {
      if (user) {
        toast.success("User has been successfully loaded from the store.");
      } else {
        toast.info("You are not logged in.");
      }

      if (!this.shouldCancel) {
        this.setState({ user });
      }
    });
  };

  fetchAllArticles = () => {
    // Fetch articles from the article service
    fetch("http://localhost:8081/articles")
        .then((response) => {
          if (!response.ok) {
            throw new Error("Failed to fetch articles");
          }
          return response.json();
        })
        .then((data) => this.setState({ articles: data }))
        .catch((error) => {
          console.error(error);
        });
  };

  fetchCommentsByArticleId = (articleId) => {
    fetch(`http://localhost:8082/commentbyaid?articleId=${articleId}`)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Failed to fetch comments");
          }
          return response.json();
        })
        .then((data) => this.setState({ comments: data }))
        .catch((error) => {
          console.error(error);
        });
  };

  handleArticleClick = (articleId) => {
    this.fetchCommentsByArticleId(articleId);
  };
  render() {
    const { articles } = this.state;
    const { comments } = this.state;
    return (
        <>
          <ToastContainer />
          <Buttons
              login={this.login}
              logout={this.logout}
              getUser={this.getUser}
              callApi={this.callApi}
          />
          <MDBContainer className="py-5">
            <MDBCard style={{ width: "100%" }}>
              <div className="border border-left border-right px-0">
                <div className="p-3 border-bottom">
                  <h4 className="d-flex align-items-center mb-0">
                    Latest Articles
                    <MDBIcon far icon="star" size="xs" color="primary" className="ms-auto" />
                  </h4>
                </div>
                <MDBCard className="shadow-0">
                  {articles.map((article) => (
                      <MDBCardBody className="border-bottom pb-2" key={article.articleId}>
                        <div className="d-flex">
                          <div className="d-flex flex-column w-100 ps-3" onClick={() => handleArticleClick(article.articleId)}>
                            <h2>{article.articleTitle}</h2>
                            <h3>{article.articleContext}</h3>
                            <p>Created on: {new Date(article.creationDate).toLocaleDateString()}</p>
                          </div>
                        </div>
                      </MDBCardBody>
                  ))}
                </MDBCard>

              </div>
            </MDBCard>
          </MDBContainer>
          {this.state.api && (
              <AuthContent data={this.state.api} user={this.state.user} />
          )}
        </>
    );
  }
}
